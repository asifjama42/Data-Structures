  #include <iostream>

using namespace std;
struct Node{
    int data;
    Node *left,*right;
    Node(int key ){
        data = key;
        left = nullptr;
        right = nullptr;
    };
};
void deleteBinaryTree(Node* &root){
    if(root==nullptr) return ;
    
    deleteBinaryTree(root->left);
    deleteBinaryTree(root->right);
    std::cout << root->data << " deleting"<< std::endl;
   // delete root;    
    root = nullptr;
};

// iterative approach to delete a binary tree
// delete each node in the queue one by one after pushing their children to the queue.
// Note that we’re deleting a parent here before deleting its children’s as 
// we’re pushing them into the queue and they will be processed and deleted afterwards.

void deleteBinaryTreeItt(Node* &root){
    if(root==nullptr) return;
    queue<Node*> queue ;
    queue.push(root);
    Node* front = nullptr;
    while(!queue.empty()){
        front = queue.front();
        queue.pop();
        if(front->left){
            queue.push(front->left);
        }
        if(front->right){
            queue.push(front->right);
        }
        delete front;
    }
}

void printTree(Node* &root){
    if(root==nullptr){
        return;
        
    }
    printTree(root->left);
    cout<<root->data<<"->";
    printTree(root->right);
    
    
};
int main()
{
    Node *root = nullptr;
    root = new Node(15);
    root->left = new Node(10);
    root->right = new Node(20);
    root->left->left = new Node(8);
    root->left->right = new Node(12);
    root->right->left = new Node(16);
    root->right->right = new Node(25);
    printTree(root);
    deleteBinaryTreeItt(root);
    if(root==nullptr){
        cout<<"Tree deleted successfully..";
    }
    printTree(root);
    //Node *temp = root->right->right;
    //delete temp;
    
    //temp = nullptr;
    //cout<<"\n";
    printTree(root);
    return 0;
}
