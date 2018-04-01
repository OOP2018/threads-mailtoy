## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |    1,000,000       |   0.0116602     |
| Using ReentrantLock     |    1,000,000       |   0.1515773     |
| Syncronized method      |    1,000,000       |   0.0904583     |
| AtomicLong for total    |    1,000,000       |   0.0332453     |

## 1. Using unsynchronized counter object

answer the questions (1.1 - 1.3)

Q: Run the ThreadSum program using limit = 1,000 (a small number). Run it several times (5 or more). The total should be zero. Is it? Is the total always the same?
```
A: The total should be zero, but thread1 run same time as thread2 and use the same counter. 
Sometimes thread1 and thread2 call counter at the same time. It's possible that thread1 run 
finished before thread2 then replace  new counter value. After that thread2 replace new counter 
value too, so it’s not zero.
```

## 2. Implications for Multi-threaded Applications
```
A: If people withdraw or deposit money from the same account at the same time. In the case of 
the original account has 1000 baht, but people will withdraw 1000 and another person will 
deposit 500 baht. Now that the withdrawal money and update the remaining money back to it will 
be zero. In fact, the remaining money in the account 500.
``` 

## 3. Counter with ReentrantLock
/br
answer questions 3.1 - 3.4

3.1 Describe the results. Is the total always zero? Record the average runtime in README.md
```
A: Yes, the total always zero.
```

3.2 Explain why the results are different from problem 1.
```
A: Because problem 1 doesn't use lock() and unlock() method.
```

3.3 What does a ReentrantLock do? Why (and when) would you use it in a program?
```
A: If thread1 use counter, so thread2 can not use count value as same time (lock.lock()) until 
thread1 finished, then thread2 will use counter value. The total always zero.

We use it in a program when we want only one thread can use value, another thread can use after 
thread don't lock or unlock.
```

3.4 Why do we write "finally { lock.unlock(); }" in the code?
```
A: Because thread lock.lock ,so another thread can not use counter. Use lock.unlock() for 
thread2 can use counter.
```

## 4. Counter with synchronized method

answer question 4

4.1 Describe the results. Is the total 0? Return the average run time in README.md.
```
A: Yes, the total is zero.
```

4.2 Explain why the results are different from problem 1.
```
A: It use synchronized for lock the method, so that another thread can not access the method.
```

4.3 What is the meaning of "synchronized"? Why (and when) would you use it in a program?
```
A: When thread1 use the method, so that thread2 can not access the method as the same time.

We use it in a program when we want only one thread can use method, or the method have a few 
statement it do not waste your time to declare Lock.
```


## 5. Counter with AtomicLong

answer question 5
5.1 Run the program a few times. AtomicCounter does not use a lock (like problem 3) and the add
method isn't synchronized, but it still fixes the error in problem 1. Explain why.
```
A: AtomicCounter use AtomicLong, AtomicLong is already lock.lock() and lock.unlock().
```

5.2 Describe why and when you would use AtomicLong (or AtomicDouble, AtomicInteger) in a program.
```
A: Have only long type then AtomicCounter is faster than synchronized. ่It's optimize by java.
```

## 6. Analysis of Results

answer question 6

6.1 Compare the average run-times of all the solutions. Which one is fastest? Which is slowest?
```
A: Using ReentrantLock  > Syncronized method > AtomicLong for total
Using ReentrantLock is slowest. tomicLong for total is fastest.
```

6.2. Which of the above solutions can be applied to the broadest range of problems where you need to ensure that only one thread modifies the resource at any one time? The "resource" could be a lot more complex than adding to a single variable (such as a List).
```
A: Syncronized method, it do not waste your time to declare Lock. Unlimited types of variables 
to use.
```

## 7. Using Many Threads (optional)

