from Node import *

class Stack:
    # Node-based queue
    def __init__(self):
        self.head = None
        self.tail = None
        self.count = 0

    def enqueue(self, data):
        new_node = NodeListDoubly(data, None, None)
        # new_node = node

        if self.head is None:  # Se a lista estiver vazia
            self.head = new_node  # Adicionamos o nó como primeiro da fila
            self.tail = self.head  # Como só tem 1 nó, ele também é o último

        else:  # Se não estiver vazia
            new_node.previous = self.tail  # O último torna-se o anterior ao novo nó
            self.tail.next = new_node  # O novo nó torna-se o próximo do tail
            self.tail = new_node  # O novo nó agora é o último (tail) da fila

        self.count += 1

    def dequeue(self):
        # Como se fosse o método pop
        current = self.head

        if self.count == 1:  # Temos apenas um nó (sendo tanto o 'head' tanto o 'tail')
            self.count -= 1
            self.head = None
            self.tail = None

        elif self.count > 1:
            self.head = self.head.next
            self.head.previous = None
            self.count -= 1

    def pop(self):
        current = self.head

        if self.count == 1:
            self.head = None
            self.tail = None
            self.count -= 1
            return current.data

        elif self.count > 1:
            self.head = self.head.next
            self.head.previous = None
            self.count -= 1
            return current.data

    def print_queue(self, num):
        current = self.head
        result = ''

        while current:
            if current is self.head and current is self.tail:
                result = result + 'nº' + str(num) + ' [' + str(current.data.data) + ']'
                current = current.next
            elif current is self.head:
                result = result + 'nº' + str(num) + ' [' + str(current.data.data) + '; '
                current = current.next
            elif current is self.tail:
                result = result + str(current.data.data) + ']'
                current = current.next
            else:
                result = result + str(current.data.data) + '; '
                current = current.next

        print(result)
