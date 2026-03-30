class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
       operators = {"+","-","*","/"}
       stack = []
       for token in tokens:
          if token not in operators:
              stack.append(int(token))
          else:
              num2 = stack.pop()
              num1 = stack.pop()
              if token == "+":
                  num = num1 + num2
              elif token == "-":
                  num = num1 - num2
              elif token == "*":
                  num = num1 * num2
              else:
                  num = int(num1 / num2)
              stack.append(int(num))
       return stack[-1]
