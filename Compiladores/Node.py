class NodeList:

    def __init__(self, data=None):
        self.numero = data
        self.next = None


class NodeListDoubly:

    def __init__(self, data=None, next=None, previous=None):
        self.data = data
        self.next = next
        self.previous = previous