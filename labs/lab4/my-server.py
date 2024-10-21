from flask import Flask, request, jsonify

app = Flask(__name__)

VALID_TOKEN = "f99aa8b8573062e9802f4fc0807ae1cb"
@app.route("/")
def hello():
    return "You called \n"

@app.route("/login", methods=['POST'])
def login():
    data = request.form
    if data.get("id") == "phillip.bradford@uconn.edu" and data.get("token") == VALID_TOKEN:
        return jsonify({"message": "Login successful"}), 200
    else:
        return jsonify({"message": "Invalid credentials or token"}), 401

# curl -d "text=Hello!&param2=value2" -X POST http://localhost:5000/echo
@app.route("/echo", methods=['POST'])
def echo():
   text = request.form.get('text')
   param2 = request.form.get('param2')
   body = request.form.get('body')

   response_data = {}
   
   # Add only the provided fields to the response
   if text is not None:
      response_data['text'] = text
   if param2 is not None:
      response_data['param2'] = param2
   if body is not None:
      response_data['body'] = body

   return jsonify(response_data), 200

if __name__ == "__main__":
   app.run(host='0.0.0.0')