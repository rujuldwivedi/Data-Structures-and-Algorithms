public class Pair <T, U>
{

    /*
     * Here we'll do the following:
     * 1. Implement the pair class for use as generic data type in other classes
     */

     T first;
     U second;
 
     public Pair(T first, U second)
     {
         this.first = first;
         this.second = second;
     }

        public T getFirst()
        {
            return first;
        }

        public U getSecond()
        {
            return second;
        }

        public void setFirst(T first)
        {
            this.first = first;
        }

        public void setSecond(U second)
        {
            this.second = second;
        }

        @Override
        public String toString()
        {
            return "(" + first + ", " + second + ")";
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;
        }

        @Override
        public int hashCode()
        {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        public static void main(String[] args)
        {
            System.out.println();
        }

}
