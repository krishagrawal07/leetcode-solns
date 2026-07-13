class StockSpanner {

    // Stack me {price, index} store karenge
    Stack<int[]> st;

    // Current day ka index
    int index;

    public StockSpanner() {
        st = new Stack<>();
        index = 0;
    }

    public int next(int price) {

        // Current price se chhote ya equal prices hata do
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }

        int span;

        // Agar koi previous greater element nahi mila
        if (st.isEmpty()) {
            span = index + 1;
        } else {
            // Current index - Previous Greater Element ka index
            span = index - st.peek()[1];
        }

        // Current price aur uska index stack me store karo
        st.push(new int[]{price, index});

        // Next day ke liye index badha do
        index++;

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */