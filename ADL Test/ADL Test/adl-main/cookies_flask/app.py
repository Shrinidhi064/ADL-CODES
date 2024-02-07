from flask import Flask, render_template, request, make_response

app = Flask(__name__)

@app.route('/')
def index():
    count = int(request.cookies.get('count', 0))
    count += 1
    response = make_response(f"No of visits :{count}")
    response.set_cookie('count', str(count))
    return response

if __name__ == '__main__':
    app.run(debug=True)
