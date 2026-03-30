class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operators = {"+","-","*","/"}
        stack = []
        for token in tokens:
            if token not in operators:
                stack.append(token)
            else:
                num2 = stack.pop()
                num1 = stack.pop()
                if token == "+":
                    num = int(num1) + int(num2)

                elif token == "-":
                     num = int(num1) - int(num2)

                elif token == "*":
                     num = int(num1) * int(num2)
                else:
                     num = int(num1) / int(num2)
                stack.append(num)
        return int(stack[-1])
