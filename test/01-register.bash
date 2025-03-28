#!/bin/bash
set -e
set -x

# Define the API endpoint URL
API_URL="http://localhost:8888/api/auth/signup"

# Define the user data

USERNAME="whiplash"

EMAIL="whiplash@embanet.online"

PASSWORD="garuda"

ROLE="user"

# Create the JSON payload
PAYLOAD="{\"username\":\"$USERNAME\", \"email\":\"$EMAIL\", \"password\":\"$PASSWORD\", \"role\":[\"$ROLE\"]}"

# Send a POST request to the API endpoint with the JSON payload
curl -s -X POST -H "Content-Type: application/json" -d "$PAYLOAD" "$API_URL"

# Check the response code
if [ $? -eq 0 ]; then

    echo

    echo "User registered successfully!"

    echo

else

    echo

    echo "Error registering user. Please check the API response."

    echo

fi
