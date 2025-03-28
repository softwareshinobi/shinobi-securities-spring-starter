#!/bin/bash

# Define the API endpoint URL
API_URL="http://localhost:8888/api/test/user"

curl -X GET $API_URL \
     -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImlhdCI6MTczNTI0MzE3OSwiZXhwIjoxNzM1MjQzMjM5fQ.wGdu2DYGJPrJOYsPBKKwg4wwWhBCqT8kaYh9NemRIHY" \
     -H "Other-Header: Header-Value"
