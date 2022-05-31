package ru.db.Zagrebina;

public interface Persons {//заканчивается на able-способность что-то делать.
    boolean isPlay();
    void setPlay(boolean play);
    int getJumpLimit();
    int getRunLimit();

    //дефолтный метод - это метод который можно прописать в интерфейся с реализацией. Его не обязательно переопределять в наследниках. Можно переопределить если есть разница в реализации у разных наследников
   default void run(Track track) {
       if (isPlay()) {
           if (getRunLimit() >= track.getLength()) {
               System.out.println(this + " Успешно преодолел " + track);
           } else {
               System.out.println(this + " Не прошел препятствие " + track);
               setPlay(false);
           }
       }
   }
    default void jump(Wall wall){
        if (isPlay()) {
            if (getJumpLimit() >= wall.getHeight()) {
                System.out.println(this + "У спешно преодолел " + wall);
            } else {
                System.out.println(this + " Не прошел препятствие " + wall);
                setPlay(false);
            }
        }
    }


}
