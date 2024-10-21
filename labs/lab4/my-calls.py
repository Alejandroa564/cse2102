import httpx

url = "http://localhost:5000/"

authData = {
    "id": "phillip.bradford@uconn.edu",
    "token": "f99aa8b8573062e9802f4fc0807ae1cb"
}

authData1 = {
    "id": "phillip.bradford@uconn.edu",
    "token": "wrong"
}

authData2 = {
    "id": "wrong",
    "token": "f99aa8b8573062e9802f4fc0807ae1cb"
}

response = httpx.post(url + "login", data=authData)
print(response.status_code)
print(response.text)

response = httpx.post(url + "login", data=authData1)
print(response.status_code)
print(response.text)

response = httpx.post(url + "login", data=authData2)
print(response.status_code)
print(response.text)


mydata = {
    "text": "Hello Phil!",
    "param2": "Making a POST request",
    "body": "my own value"
}

for key, value in mydata.items():
    # Create a separate payload for each request
    payload = {key: value}

    # A POST request to the echo API
    response = httpx.post(url + "echo", data=payload)

    # Print the response for each request
    print(f"Response for {key}:")
    print(response.status_code)
    print(response.json())