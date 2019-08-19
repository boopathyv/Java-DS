> public void start()

Starts the thread in a separate path of execution, then invokes the run() method on this Thread object.

	
> public void run()

If this Thread object was instantiated using a separate Runnable target, the run() method is invoked on that Runnable object.


> public final void setName(String name)

Changes the name of the Thread object. There is also a getName() method for retrieving the name.


> public final void setPriority(int priority)

Sets the priority of this Thread object. The possible values are between 1 and 10.


> public final void setDaemon(boolean on)

A parameter of true denotes this Thread as a daemon thread.


> public final void join(long millisec)

The current thread invokes this method on a second thread, causing the current thread to block until the second thread terminates or the specified number of milliseconds passes.


> public void interrupt()

Interrupts this thread, causing it to continue execution if it was blocked for any reason.


> public final boolean isAlive()

Returns true if the thread is alive, which is any time after the thread has been started but before it runs to completion.


> public static void yield()

Causes the currently running thread to yield to any other threads of the same priority that are waiting to be scheduled.


> public static void sleep(long millisec)

Causes the currently running thread to block for at least the specified number of milliseconds.


> public static boolean holdsLock(Object x)

Returns true if the current thread holds the lock on the given Object.


> public static Thread currentThread()

Returns a reference to the currently running thread, which is the thread that invokes this method.


> public static void dumpStack()

Prints the stack trace for the currently running thread, which is useful when debugging a multithreaded application.


> public void suspend()

This method puts a thread in the suspended state and can be resumed using resume() method.

> public void stop()

This method stops a thread completely.

	
> public void resume()

This method resumes a thread, which was suspended using suspend() method.

# DEADLOCK
https://www.tutorialspoint.com/java/java_thread_deadlock.htm

# SUSPEND(),RESUME()
https://www.tutorialspoint.com/java/java_thread_control.htm