package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when{
            this.year != other.year -> this.year - other.year
            this.month != other.month -> this.month - other.month
            else -> this.dayOfMonth - other.dayOfMonth
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(int : Int):RepreatedIntervals{
    return RepreatedIntervals(this,int)
}

operator fun MyDate.plus(timeInterval: TimeInterval) : MyDate {
    return this.addTimeIntervals(timeInterval, 1)
}

operator fun MyDate.plus(timeInterval: RepreatedIntervals) : MyDate {

    var date = this
    for(i in 1..timeInterval.times){
        date += timeInterval.inter
    }
    return date
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>, Iterator<MyDate> {
    var startDate = start
    override fun hasNext(): Boolean {
        return startDate <= endInclusive
    }

    override fun next(): MyDate {
        var temp = startDate
        startDate = startDate.nextDay()
       return temp
    }

    override operator fun contains(value: MyDate): Boolean{
        return value >= start && value <= endInclusive
    }
}
class RepreatedIntervals(interval : TimeInterval, n : Int){
    var inter = interval
    var times = n
}
