package homework5.person;


import homework5.person.homework5.JobType;
import homework5.person.homework5.Working;

public abstract class Employee implements Working {
    protected String fullName;
    protected int age;
    protected JobType jobType;
    protected double salary;
    protected Experience exp;

    private Employee(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public Employee(String fullName, int age, JobType jobType, Experience exp) {
        this(fullName, age);
        this.jobType = jobType;
        this.exp = exp;
    }

    public Employee(String fullName, int age, String jobTypeStr, int expInt) {
        this(fullName, age);
        if (expInt < 0) {
            throw new IllegalArgumentException("experience cannot be less that 0");
        }
        if (jobTypeStr == null || jobTypeStr.trim().length() == 0) {
            throw new IllegalArgumentException("job type cannot be blank");
        }
        Experience experience;
        if (expInt <= 2) {
            experience = Experience.JUNIOR;
        } else if (expInt <= 4) {
            experience = Experience.MIDDLE;
        } else {
            experience = Experience.SENIOR;
        }
        this.exp = experience;
        JobType jobType = null;
        if (JobType.QA.toString().equalsIgnoreCase(jobTypeStr)) {
            jobType = JobType.QA;
        } else if (JobType.DEVELOPER.toString().equalsIgnoreCase(jobTypeStr)) {
            jobType = JobType.DEVELOPER;
        }
        this.jobType = jobType;
    }

    public void setJob(JobType jobType) {
        this.jobType = jobType;
    }

    public JobType getJob (){
        return jobType;
    }
}
