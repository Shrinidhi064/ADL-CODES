from flask import Flask, render_template, request

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('login.html')

@app.route('/login', methods=['POST'])
def login():
    username = request.form['username']
    password = request.form['password']

    if username == 'admin' and password == 'password':
        message = 'Hello ' + username
    else:
        message = 'Login failed'

    return render_template('message.html', message=message)

if __name__ == '__main__':
    app.run(debug=True)
