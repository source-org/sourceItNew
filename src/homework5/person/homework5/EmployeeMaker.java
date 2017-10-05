package homework5.person.homework5;

import homework5.person.Employee;

public final class EmployeeMaker {

    public static Object maker (Employee employee) {
        if (employee.getJob()==JobType.DEVELOPER) {
            return "Developer";
        }
        if (employee.getJob() == JobType.QA) {
            return "Qa";
        }
        return null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
