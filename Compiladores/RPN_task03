from Token import *
import re

class Regex:

    def __init__ (self):
        self.regexNum = "[0-9]"
        self.regexNumPadrao = re.compile(self.regexNum)
        self.regexOp = "[+-/*]"
        self.regexOpPadrao = re.compile(self.regexOp)

    def isNum (self, token):
        if self.regexNumPadrao.findall(token):
            return True
        else:
            return False
    
    def isOp (self, token):
        if self.regexOpPadrao.findall(token):
            return True
        else:
            return False

class RPNStackerScanner:

    def __init__ (self):
        self.entry = []
        self.tokens = []
        self.tokensRegister = []
        self.file = 'Calc1.stk'
        self.regex = Regex()

    def run (self):
        self.readEntry()
        self.scanner()
        # Printa o resultado através do lexema do último token restante na pilha
        print(self.tokens[0].getLexeme())
        # Printa o próprio token do resultado
        print("\nToken do resultado: ")
        self.printTokens()
        # Printa o registro de todos os tokens que aconteceram na análise
        print('Registro de todos os tokens: \n')
        self.printTokensRegister()
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
        while (len(self.entry) >= 1):
            # Varrer entrada até acabar o array entry
            firstEntry = self.entry.pop(0)
            if (self.regex.isNum(firstEntry)):

                # Cria token e adiciona no array
                token = Token(TokenType.NUM, firstEntry)
                self.tokens.append(token)
                self.tokensRegister.append(token)
            
            elif (len(self.tokens) >= 2):

                # Operador e operandos retirados da pilha de tokens                
                if self.regex.isOp(firstEntry):
                    
                    if firstEntry == '+':
                        # Cria token e adiciona no array
                        token = Token(TokenType.PLUS, firstEntry)
                        self.tokens.append(token)
                        self.tokensRegister.append(token)
                    elif firstEntry == '-':
                        # Cria token e adiciona no array
                        token = Token(TokenType.MINUS, firstEntry)
                        self.tokens.append(token)
                        self.tokensRegister.append(token)
                    elif firstEntry == '*':
                        # Cria token e adiciona no array
                        token = Token(TokenType.STAR, firstEntry)
                        self.tokens.append(token)
                        self.tokensRegister.append(token)
                    elif firstEntry == '/': 
                        # Cria token e adiciona no array
                        token = Token(TokenType.SLASH, firstEntry)
                        self.tokens.append(token)
                        self.tokensRegister.append(token)
                    else:
                        print("Erro! analysis fail")
                        return
                
                else:
                    print("Operador inexistente")

                # Resolvendo a operação a partir dos Tokens
                resultado = 0
                operador = self.tokens.pop(2)
                operando2 = int (self.tokens.pop(1).getLexeme())
                operando1 = int (self.tokens.pop(0).getLexeme())

                # Checando qual operador é através do token
                if operador.type == TokenType.PLUS:
                    resultado = operando1 + operando2
                elif operador.type == TokenType.MINUS:
                    resultado = operando1 - operando2
                elif operador.type == TokenType.STAR:
                    resultado = operando1 * operando2
                elif operador.type == TokenType.SLASH:
                    resultado = operando1 / operando2

                resultToken = Token(TokenType.NUM, resultado)
                # Empilha o token do resultado
                self.tokens.append(resultToken)
                
            else:
                print("Error: Unexpected character: ", firstEntry)
                return
        return


    def printTokens (self):
        tokens = ""

        while (len(self.tokens) > 0):
            tk = self.tokens.pop(0)
            tokens += str (tk.toString()) + "\n"

        print(tokens)

    def printTokensRegister (self):
        tokens = ""

        while (len(self.tokensRegister) > 0):
            tk = self.tokensRegister.pop(0)
            tokens += str (tk.toString()) + "\n"

        print(tokens)

RPNStackerScanner = RPNStackerScanner()
RPNStackerScanner.run()