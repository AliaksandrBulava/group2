#Thread Default Task 05. Threads coordination
We have two wrestlers in opposition. One increments counter and one decrements. Counter must not fall below zero.
1. Run app. Observe how 'below zero' appears. Review the code and try to explain why it happens.
2. Modify Counter class. Add coordination lock with wait/notify to avoid 'below zero' situation.

Used sources:
https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html