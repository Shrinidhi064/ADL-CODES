from flask import Flask, render_template, request

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('./calculator.html')

@app.route('/calculate', methods=['POST'])
def calculate():
    num1 = int(request.form['num1'])
    num2 = int(request.form['num2'])
    operator = request.form['operator']
    result = 0

    if operator == '+':
        result = num1 + num2
    elif operator == '-':
        result = num1 - num2
    elif operator == '*':
        result = num1 * num2
    elif operator == '/':
        result = num1 / num2

    return render_template('./result.html', result=result)

if __name__ == '__main__':
    app.run(debug=True)