package com.intellekta.queue_deque_stack_llist_installer;

import java.util.*;

public class Installer implements Subsystem {

    private String name;
    private int version;
    private Subsystem[] prerequisites;
    Queue<Subsystem> installers = new PriorityQueue<>(Comparator.comparing(Subsystem::getPrerequisites, Comparator.nullsFirst(null))
            .thenComparing(Subsystem::getVersion).thenComparing(Subsystem::getName));

    public Installer(String name, int version, Subsystem[] prerequisites) {
        this.name = name != null ? name : "Default";
        this.version = Math.max(version, 0);
        this.prerequisites = prerequisites == null || prerequisites.length == 0 ? null : prerequisites;
    }

    public Installer() {
        name = "Default";
        version = 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setPrerequisites(Subsystem[] prerequisites) {
        this.prerequisites = prerequisites;
    }

    private void setUpPlan(Subsystem[] prerequisites) {
        if (prerequisites != null) {
            for (Subsystem prerequisite : prerequisites) {
                if (prerequisite != null && !installers.contains(prerequisite)) {
                    installers.offer(prerequisite);
                    this.setUpPlan(prerequisite.getPrerequisites());
                } else if (prerequisite != null && installers.contains(prerequisite)) {
                    System.out.printf("SetUp plan calculation failed. Wrong prerequisite description at %s %s.", prerequisite.getName(), prerequisite.getVersion());
                    installers = null;
                    return;
                } else {
                    System.out.println("SetUp plan calculation failed.");
                    installers = null;
                    return;
                }
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public void install() {
        System.out.printf("%s version %d installed successfully\r\n", this.getName(), this.getVersion());
    }

    @Override
    public Subsystem[] getPrerequisites() {
        return prerequisites;
    }

    public void setUp() {
        if (this.name != null) {
            installers.offer(this);
            this.setUpPlan(prerequisites);
            if (installers != null) {
                System.out.println(installers.size() + " Размер очереди");
                while (!installers.isEmpty())
                    installers.poll().install();
            }
        }
    }

    @Override
    public String toString() {
        return "Installer{" +
                "name='" + name + '\'' +
                ", version=" + version +
                ", prerequisites=" + Arrays.toString(prerequisites) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Installer installer)) return false;
        return getVersion() == installer.getVersion() && getName().equals(installer.getName()) && Arrays.equals(getPrerequisites(), installer.getPrerequisites());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getVersion());
        result = 31 * result + Arrays.hashCode(getPrerequisites());
        return result;
    }

}
