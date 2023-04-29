from enum import Enum

class TokenType(Enum):

    # Literals
    NUM = 1
    # Single-character tokes for operations
    MINUS = 2
    PLUS = 3
    SLASH = 4
    STAR = 5
    # End-of-file
    EOF = 6

class Token:

    def __init__ (self, type, value):
        self.type = type
        self.lexeme = value

    def toString (self):
        token = "Token: [type=" + str(self.type.name) + ", lexeme=" + str(self.lexeme) + "]"
        return token
    
    def getLexeme (self):
        return self.lexeme