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