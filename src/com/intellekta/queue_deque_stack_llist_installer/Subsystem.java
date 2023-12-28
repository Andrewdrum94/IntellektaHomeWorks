package com.intellekta.queue_deque_stack_llist_installer;

public interface Subsystem {

    String getName();
    int getVersion();
    void install();
    Subsystem[] getPrerequisites();
}
