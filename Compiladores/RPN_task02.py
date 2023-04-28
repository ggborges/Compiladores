from Token import *

class RPNStackerScanner:

    def __init__ (self):
        self.stack = []
        self.entry = []
        self.tokens = []
        self.operators = ['+', '-', '*', '/', '**']
        self.file = 'Calc1.stk'

    def run (self):
        self.readEntry()
        self.scanner()
        print(self.stack[0])
        return

    def readEntry (self):
        file = open(self.file, 'r')
        self.entry = file.read().split()

        # print(self.entry)
        return
    
    def analysis (self, entry):
        print("Analysis")
        while (len(self.entry) >= 1):
            print("Varredura")
            # Varrer entrada até acabar o array entry
            firstEntry = self.entry.pop(0)
            if (firstEntry.isdigit()):
                print("É dígito: " + firstEntry)
                self.stack.append(int (firstEntry))
            
            elif (len(self.stack) >= 2):
                # Operador colocado na pilha
                print("É operador: " + firstEntry)
                self.stack.append(firstEntry)

                # Operador e operandos retirados da pilha
                operador = self.stack.pop(2)
                operando2 = self.stack.pop(1)
                operando1 = self.stack.pop(0)
                
                resultado = 0

                if operador in self.operators:
                    
                    if operador == '+':
                        resultado = operando1 + operando2
                    elif operador == '-':
                        resultado = operando1 - operando2
                    elif operador == '*':
                        resultado = operando1 * operando2
                    elif operador == '/':
                        resultado = operando1 / operando2
                    elif operador == '**':
                        resultado = operando1 ** operando2
                    else:
                        print("Erro! analysis fail")
                        return
                    print("Resultado: ", resultado)
                    # Empilha o resultado
                    self.stack.append(resultado)
                
                else:
                    print("Operador inexistente")
            else:
                print("Operação com má formatação")
        return
    
    def scanner (self):
        print("Scanner")
        while (len(self.entry) >= 1):
            print("Varredura")
            # Varrer entrada até acabar o array entry
            firstEntry = self.entry.pop(0)
            if (firstEntry.isdigit()):
                print("É dígito: " + firstEntry)
                self.stack.append(int (firstEntry))

                # Cria token e adiciona no array
                token = Token(TokenType.NUM, firstEntry)
                self.tokens.append(token)
            
            elif (len(self.stack) >= 2):
                # Operador colocado na pilha
                print("É operador: " + firstEntry)
                self.stack.append(firstEntry)
                
                # Operador e operandos retirados da pilha
                operador = self.stack.pop(2)
                operando2 = self.stack.pop(1)
                operando1 = self.stack.pop(0)
                
                resultado = 0

                if operador in self.operators:
                    
                    if operador == '+':
                        resultado = operando1 + operando2
                        # Cria token e adiciona no array
                        token = Token(TokenType.PLUS, firstEntry)
                        self.tokens.append(token)
                    elif operador == '-':
                        resultado = operando1 - operando2
                        # Cria token e adiciona no array
                        token = Token(TokenType.MINUS, firstEntry)
                        self.tokens.append(token)
                    elif operador == '*':
                        resultado = operando1 * operando2
                        # Cria token e adiciona no array
                        token = Token(TokenType.STAR, firstEntry)
                        self.tokens.append(token)
                    elif operador == '/':
                        resultado = operando1 / operando2
                        # Cria token e adiciona no array
                        token = Token(TokenType.SLASH, firstEntry)
                        self.tokens.append(token)
                    else:
                        print("Erro! analysis fail")
                        return
                    print("Resultado: ", resultado)
                    # Empilha o resultado
                    self.stack.append(resultado)
                
                else:
                    print("Operador inexistente")
            else:
                print("Error: Unexpected character: ", firstEntry)
                return

        self.printTokens()
        return

    def printTokens (self):
        tokens = ""

        while (len(self.tokens) > 0):
            tk = self.tokens.pop(0)
            tokens += str (tk.toString()) + "\n"

        print(tokens)

RPNStackerScanner = RPNStackerScanner()
RPNStackerScanner.run()