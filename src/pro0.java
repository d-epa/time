import java.util.ArrayList;

        public class pro0 {

            public static class TodoList {

                private ArrayList<Task> theList;

                public void main(String[] args)
        {

            TodoList myList = new TodoList();

            myList.add("Wake up Time");
            myList.add("Excercise");
            myList.add("Affimation");
            myList.add("Deep Hours");
            myList.add("Nap Time");
            myList.add("Self care");
            myList.add("Plan your day");

            myList.done("Wake Up Time");
            myList.done("Affirmation");

            myList.todolistAusgeben();

        }

        public TodoList()
        {
            theList = new ArrayList<Task>();
        }

        public void add(String activity)
        {
            theList.add(new Task(activity));
        }

        public Task get(String activity)
        {
            for (Task task : theList)
                if (task.isCalled(activity))
                    return task;

            return null;
        }

        public void done(String activity)
        {
            Task task = get(activity);

            if (task != null)
                task.done();
        }

        public void todolistAusgeben()
        {
            int sizeOfList = theList.size();
            for (int i=0; i < sizeOfList; i++) {
                Task sTodo = theList.get(i);
                System.out.println(sTodo);
            }
        }

        private class Task {

            private String name;
            private boolean status;

            public Task(String name)
            {
                this.name = name;
                this.status = false;
            }

            public boolean isCalled(String name)
            {
                return this.name.equals(name);
            }

            public void done()
            {
                status = true;
            }

            public String toString()
            {
                return name + " : " + (status ? "DONE" : "Waiting...");
            }

        }

    }


}