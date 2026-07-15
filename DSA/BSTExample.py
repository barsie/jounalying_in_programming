
class FlaggedTransactionNode: 
    """Represents a single flagged transaction stored in the BST.""" 
    def __init__(self, transaction_identifier, risk_description): 
        self.transaction_identifier = transaction_identifier 
        self.risk_description = risk_description 
        self.left_child = None 
        self.right_child = None 
        
class FraudDetectionBinarySearchTree: 
    """Binary Search Tree used to manage flagged transactions.""" 
    def __init__(self): self.root_transaction = None 
    def insert_flagged_transaction(self, transaction_identifier, risk_description): 
        """Insert a new flagged transaction into the BST.""" 
        new_transaction_node = FlaggedTransactionNode( transaction_identifier, risk_description ) 
        
        if self.root_transaction is None: 
            self.root_transaction = new_transaction_node 
            return 
        
        current_transaction_node = self.root_transaction 
            
        while True: 
            if transaction_identifier < current_transaction_node.transaction_identifier: 
                if current_transaction_node.left_child is None: 
                    current_transaction_node.left_child = new_transaction_node 
                    return 
                current_transaction_node = current_transaction_node.left_child 
            else: 
                if current_transaction_node.right_child is None: 
                    current_transaction_node.right_child = new_transaction_node 
                    return 
                current_transaction_node = current_transaction_node.right_child

if __name__ == '__main__':
    tree = FraudDetectionBinarySearchTree()
    tree.insert_flagged_transaction(102, 'high risk')
    tree.insert_flagged_transaction(50, 'medium risk')
    tree.insert_flagged_transaction(150, 'low risk')

    print(tree.root_transaction.transaction_identifier)
    print(tree.root_transaction.left_child.transaction_identifier)
    print(tree.root_transaction.right_child.transaction_identifier)



class FraudDetectionBinarySearchTree: 
    # Previous methods omitted for brevity 
    def search_transaction_by_identifier(self, transaction_identifier): 
        """Search for a flagged transaction using its Transaction ID.""" 
        current_transaction_node = self.root_transaction 
        
        while current_transaction_node is not None: 
            if ( transaction_identifier == current_transaction_node.transaction_identifier ):
                return current_transaction_node
            
            if ( transaction_identifier < current_transaction_node.transaction_identifier ): 
                current_transaction_node = current_transaction_node.left_child 
            
            else: current_transaction_node = ( current_transaction_node.right_child ) 
            return None
        
if __name__ == '__main__':
    tree = FraudDetectionBinarySearchTree()
    tree.insert_flagged_transaction(102, 'high risk')
    tree.insert_flagged_transaction(50, 'medium risk')
    tree.insert_flagged_transaction(150, 'low risk')

    result = tree.search_transaction_by_identifier(50)
    if result:
        print(result.transaction_identifier, result.risk_description)
    else:
        print('Transaction not found')


class FraudDetectionBinarySearchTree: 
    # Previous methods omitted for brevity 
    def remove_reviewed_transaction(self, transaction_identifier):
        """Remove a reviewed transaction from the BST.""" 
        self.root_transaction = self._remove_transaction( self.root_transaction, transaction_identifier ) 
    
    def _remove_transaction( self, current_transaction_node, transaction_identifier ): 
        
        if current_transaction_node is None: 
            return None 
        
        if ( transaction_identifier < current_transaction_node.transaction_identifier ): 
            current_transaction_node.left_child = self._remove_transaction( 
                current_transaction_node.left_child, 
                transaction_identifier 
            ) 
            
        elif ( transaction_identifier > current_transaction_node.transaction_identifier ): 
            current_transaction_node.right_child = self._remove_transaction( 
                current_transaction_node.right_child, transaction_identifier ) 
            
        else: 
            # Case 1: Leaf node 
            if ( current_transaction_node.left_child 
                    is None and current_transaction_node.right_child 
                is None ): return None 
        
            # Case 2: One child 
            if current_transaction_node.left_child is None: 
                return current_transaction_node.right_child 
                
            if current_transaction_node.right_child is None: 
                return current_transaction_node.left_child 
            
            # Case 3: Two children 
            inorder_successor = self.find_inorder_successor( current_transaction_node.right_child ) 
            current_transaction_node.transaction_identifier = ( inorder_successor.transaction_identifier ) 
            current_transaction_node.risk_description = ( inorder_successor.risk_description ) 
            current_transaction_node.right_child = (
                self._remove_transaction( 
                    current_transaction_node.right_child, 
                    inorder_successor.transaction_identifier 
                    ) 
                ) 
        
        return current_transaction_node 
    
    def find_inorder_successor(self, current_transaction_node): 
        """Return the smallest node in the right subtree.""" 
        while current_transaction_node.left_child is not None: 
            current_transaction_node = ( current_transaction_node.left_child ) 
            return current_transaction_node
        
if __name__ == '__main__':
    tree = FraudDetectionBinarySearchTree()
    tree.insert_flagged_transaction(102, 'high risk')
    tree.insert_flagged_transaction(50, 'medium risk')
    tree.insert_flagged_transaction(150, 'low risk')

    tree.remove_reviewed_transaction(50)
    result = tree.search_transaction_by_identifier(50)

    print('Transaction found:' if result else 'Transaction removed:')
    if result:
        print(result.transaction_identifier, result.risk_description)
    print('Root:', tree.root_transaction.transaction_identifier)
    print('Right child:', tree.root_transaction.right_child.transaction_identifier)