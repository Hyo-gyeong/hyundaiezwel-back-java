package d_datastructure.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import d_datastructure.list._LinkedList;
import d_datastructure.queue._Queue;
import d_datastructure.stack._Stack;

// 정렬하려면 비교를 해야해서 해당 인터페이스를 상속하는 애들만 들어올 수 있음
public class BinarySearchTree<E extends Comparable<E>> { 
    private Node<E> root;
    private int size;

    public int size(){
        return this.size;
    }

    public void insert(E element){
        Node<E> newNode = new Node<>(element);

        if (size == 0){
            root = newNode;
            size++;
            return;
        }
        Node<E> link = root;
        boolean sameElement = false;

        while(true){ // 같은 값은 중복해서 넣지 않음
            if (element.compareTo(link.getData()) < 0){
                if (link.left() == null){
                    link.left(newNode);
                    break;
                }
                link = link.left();
            } else if (element.compareTo(link.getData()) > 0){
                if (link.right() == null){
                    link.right(newNode);
                    break;
                }
                link = link.right();
            } else {
                sameElement = true;
                break;
            }
        }
        if (sameElement == false)
            size++;
    }
    public void delete(E e){
        Node<E> parent = null;
        Node<E> current = root;
        System.out.println(e);
        while (current != null && !current.getData().equals(e)){
            parent = current;
            if (e.compareTo(current.getData()) < 0){
                current = current.left();
            }
            else{
                current = current.right();
            }
        }
        if (current == null){ // 없는 노드
            return;
        }
        // 리프노드 삭제
        else if (current.left() == null && current.right() == null){
            if (parent == null) // root만 있는 경우
                root = null;
            else if (parent.left() == current)
                parent.left(null);
            else
                parent.right(null);
        }
        // 자식 1개인 노드 삭제
        else if (current.left() == null || current.right() == null){
            Node<E> child = current.left() == null ? current.right() : current.left();
            if (parent == null){ // 자식이 하나인 root인 경우
                root = child;
            }
            else if (parent.right() == current){
                parent.right(child);
            } else {
                parent.left(child);
            }
        }
        // 자식 2개인 노드 삭제 : 오른쪽 자식 중에 가장 작은 값을 current자리로 옮긴다 (또는 왼쪽 자식중에 가장 큰 값을 옮김)
        else {
            // 오른쪽 서브트리에서 가장 작은 값 찾기
            // 가장 작은 값을 찾기 때문에 찾은 노드는 반드시
            // 1. 왼쪽 노드가 없음
            // 2. 오른쪽 자식 노드만 있음
            Node<E> subParent = current;
            Node<E> subCurrent = current.right();
            while (subCurrent.left() != null){
                subParent = subCurrent;
                subCurrent = subCurrent.left();
            }
            // 삭제해야할 노드의 값에 찾은 최소값을 넣어주기
            current.setData(subCurrent.getData());

            // 반드시 오른쪽 자식만 있거나 리프노드이기 때문에
            if (subParent.left() == subCurrent){
                subParent.left(subCurrent.right()); // Node<E> 또는 null
            } else {
                subParent.right(subCurrent.right());
            }
        }
    }
/*
    public void delete(E target){
        Node<E> parent = null;
        Node<E> link = root;

        // 삭제할 노드를 찾는 과정
        while (link != null && target.compareTo(link.getData()) != 0){
            parent = link;
            if (target.compareTo(link.getData()) < 0){
                link = link.left();
            } else {
                link = link.right();
            }
        }

        // 값이 같거나 null인 구간까지 도착
        if (link == null){ // 없는 노드
            return;
        }
        if (link.left() == null && link.right() == null){ // leaf노드
            deleteNode(parent, link, null);
            size--;
            return;
        }
        // 자식 노드가 둘인 경우
        if (link.left() != null && link.right() != null){
            // 오른쪽 서브트리에서 가장 작은 노드(후계자) 찾기
            Node<E> successorParent = link;
            Node<E> successor = link.right();
            while (successor.left() != null){
                successorParent = successor;
                successor = successor.left();
            }

            link.setData(successor.getData());
            size--;

            // 후계자 노드가 리프노드인 경우
            if (successor.right() == null){
                deleteNode(successorParent, successor, null);
                return;
            }

            // 후계자 노드의 자식노드가 1개만(오른쪽 자식노드만 존재) 존재하는 경우
            deleteNode(successorParent, successor, successor.right());
            return;
        }
        // 자식 노드가 1개인 경우
        Node<E> child = link.left() != null ? link.left() : link.right();
        deleteNode(parent, link, child);

    }

    public void  deleteNode(Node<E> parent, Node<E> current, Node<E> child){
        // 노드가 root인 경우
        if (parent == null){
            root = child;
            return;
        }

        if (parent.left() != null && parent.left().equals(current)){
            parent.left(child);
            return;
        }
        if (parent.right() == null){
            return;
        }

        parent.right(child);
    }
*/

    // bfs : 너비우선탐색
    // 현재 노드와 인접한 모든 노드를 탐색한 후, 그 다음 레벨의 노드를 탐색하는 방식
    // DB 인덱스를 사용해 데이터를 탐색
    public _LinkedList<E> bfs(){
        _Queue<Node<E>> queue = new _Queue<>(); 
        // Queue<Node<E>> queue = new LinkedList<>();
        _LinkedList<E> result = new _LinkedList<>();

        queue.enqueue(root);
        int level = 1;

        while (!queue.isEmpty()){
            System.out.print("level " + level + ": ");
            int size = queue.size();

            for (int i = 0; i < size; i++){
                Node<E> node = queue.dequeue();
                System.out.print(node.getData() + " ");
                result.add(node.getData());

                if (node.left() != null){
                    queue.enqueue(node.left());
                }

                if (node.right() != null){
                    queue.enqueue(node.right());
                }
            }

            level++;
            System.out.println();
        }
        return result;
    }

    public List<E> preOrderRecursive(){
        List<E> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result; 
    }
    
    private void preOrderHelper(Node<E> node, List<E> result) {
        if (node == null){
            return;
        }
        result.add(node.getData());
        preOrderHelper(node.left(), result);
        preOrderHelper(node.right(), result);
    }

    public List<E> postOrderRecursive(){
        List<E> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result; 
    }

    private void postOrderHelper(Node<E> node, List<E> result) {
        if (node == null){
            return;
        }
        postOrderHelper(node.left(), result);
        postOrderHelper(node.right(), result);
        result.add(node.getData());
    }

    public List<E> inOrderRecursive(){
        List<E> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result; 
    }

    private void inOrderHelper(Node<E> node, List<E> result) {
        if (node == null){
            return;
        }
        inOrderHelper(node.left(), result);
        result.add(node.getData());
        inOrderHelper(node.right(), result);
    }

    public List<E> preOrder(){
        _Stack<Node<E>> stack = new _Stack<>();
        List<E> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node<E> pointer = stack.pop();
            list.add(pointer.getData());
            if (pointer.right() != null){
                stack.push(pointer.right());
            }
            if (pointer.left() != null){
                stack.push(pointer.left());
            }
        }
        return list;
    }

}

