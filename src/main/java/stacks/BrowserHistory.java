package stacks;

import java.util.Stack;

class BrowserHistory {
    private Stack<String> browserStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();

    public BrowserHistory(String homepage) {
        browserStack.push(homepage);
    }

    public void visit(String url) {
        while (!forwardStack.isEmpty()){
            forwardStack.pop();
        }
        browserStack.push(url);
    }
    
    public String back(int steps) {
        while(browserStack.size() > 1 && steps > 0){
            forwardStack.add(browserStack.pop());
            steps--;
        }
        return browserStack.peek();
    }
    
    public String forward(int steps) {
        while(forwardStack.size() > 0 && steps > 0){
            browserStack.add(forwardStack.pop());
            steps--;
        }
        return browserStack.peek();
    }
}