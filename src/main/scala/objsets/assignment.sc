import objsets._

val t1 =new Tweet("A", "1", 10)
val t3 = new Tweet("D", "2", 30)
val t2 =new Tweet("C", "3", 20)
val t4 =new Tweet("E", "4", 20)

val ts1 = new NonEmpty(t1, new NonEmpty(t2), new NonEmpty(t3))
val ts2 = ts1.filterAcc(x => x.retweets > 15, new Empty())

