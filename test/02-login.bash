#!/bin/bash

reset

clear
set -e
set -x

echo "##"
echo "## launch > spring api > login"
echo "##"

# Define the API endpoint URL
API_URL="http://localhost:8888/api/auth/signin"


# Define the user credentials
USERNAME="whiplash"
PASSWORD="garuda"

# Create the JSON payload
PAYLOAD='{
    "username": "'"$USERNAME"'",
    "password": "'"$PASSWORD"'"
}'

# Send a POST request to the API endpoint with the JSON payload
RESPONSE=$(curl -s -X POST -H "Content-Type: application/json" -d "$PAYLOAD" "$API_URL")

# Check the HTTP status code of the response
HTTP_STATUS=$(curl -s -o /dev/null -w "%{http_code}" "$API_URL")

if [ "$HTTP_STATUS" -eq 200 ]; then
  echo "Login successful!"
  echo "Access Token: $(jq -r '.accessToken' <<< "$RESPONSE")" 
else
  echo "Login failed. HTTP Status Code: $HTTP_STATUS"
  echo "Response Body:"
  echo "$RESPONSE"
fi
