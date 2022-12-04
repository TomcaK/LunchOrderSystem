package cz.comkop.lunchordersystem.util;

import java.util.List;

public class IdUtil {

    public static long getFreeId(List<Long> ids){
        long i = 0;
        for (; i < ids.size(); i++) {
          if (!ids.contains(i)){
              return i;
            }
        }
        return i;
    }
}
