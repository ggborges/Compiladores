class RPNStacker:

    def __init__ (self):
        self.stack = []
        self.entry = []
        self.operators = ['+', '-', '/', '*', '**']
        self.file = 'Calc1.stk'

    def run (self):
        self.readEntry()
        self.analysis(self.entry)
        print(self.stack[0])
        return

    def readEntry (self):
        file = open(self.file, 'r')
        self.entry = file.read().split()

        # print(self.entry)
        return
    
    def analysis (self, entry):

        while (len(self.entry) >= 1):
            # Varrer entrada até acabar o array entry
            firstEntry = self.entry.pop(0)
            if (firstEntry.isdigit()):
                self.stack.append(int (firstEntry))
            
            elif (len(self.stack) >= 2):
                # Operador colocado na pilha
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
                    
                    # Empilha o resultado
                    self.stack.append(resultado)
                
                else:
                    print("Operador inexistente")
            else:
                print("Operação com má formatação")
        return

RPNStacker = RPNStacker()
RPNStacker.run()