package task;

/**
 * description: TaskInfo
 * date: 2021/3/4 16:27
 * 实时计算的共性
 * 如果你的需要计算的实体并没有以下的属性
 * 那么你可以进行换算,例如将条数转化为总量,合理的设计一个权重来代表速度
 * 那么就依然可以实现需要的共性
 * @author: SmartCat
 * version: 1.0.0
 */
public abstract class TaskInfo {
    private double speed;
    private double total;
    private double used;
    private double last;
    /**
     * 状态代表了任务的生命周期
     * 1.进行中 2.暂停 3.结束
     */
    private int status;
}
