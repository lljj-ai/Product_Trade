package com.huadi.serviceImp;

import com.huadi.dao.ProductTradeDao;
import com.huadi.daoImp.ProductTradeDaoImp;
import com.huadi.service.ProductTradeService;
import com.huadi.util.TradeInfo;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author 刘杰
 * @description 交易信息显示的业务逻辑层实现类
 * @date 2020/8/10 15:31
 */
public class ProductTradeServiceImp implements ProductTradeService {
    /**
     * 交易信息的逻辑处理
     * @return 交易信息
     */
    @Override
    public List<TradeInfo> tradeProduct() throws SQLException {
        ProductTradeDao productTradeDao=new ProductTradeDaoImp();
        List<TradeInfo> list=productTradeDao.tradeProduct();
        List<Integer> listTimes=productTradeDao.tradeTimes();
        //List<Integer> listProfit=productTradeDao.tradeProfit();
        Iterator<TradeInfo> iterator=list.iterator();
        //System.out.println(listProfit);
        Object[] object1=listTimes.toArray();
        //Object[] object2=listProfit.toArray();
        int i=0;
        while(iterator.hasNext()){
          iterator.next().setTradeTimes((int)object1[i]);
          i=i+1;
        }
        /*i=0;
        while(iterator.hasNext()){
            iterator.next().setProfit((int)object2[i]);
            i=i+1;
        }*/
        return list;

/*         TradeInfo[] object= (TradeInfo[]) list.toArray();
       Object[] object1=listTimes.toArray();
        Object[] object2=listProfit.toArray();
        for(int i=0;i<object.length;i++){
            object[i].setTradeTimes((Integer) object1[i]);
            object[i].setProfit((Integer) object2[i]);
        }
        List<TradeInfo> list1= Arrays.asList(object);*/
/*        Iterator<Integer> timesIterator=listTimes.iterator();
        Iterator<Integer> profitIterator=listProfit.iterator();
        while(iterator.hasNext()){
            iterator.next().setTradeTimes(timesIterator.next());
            iterator.next().setProfit(profitIterator.next());
        }*/
    }

    /**
     * 交易次数
     * @return
     * @throws SQLException
     */
    /*@Override
    public List<Integer> tradeTimes()throws SQLException {
        ProductTradeDao productTradeDao=new ProductTradeDaoImp();
        List<Integer> listTimes=productTradeDao.tradeTimes();
        return listTimes;
    }*/

    /**
     * 交易利润
     * @return
     * @throws SQLException
     */
    @Override
    public List<Integer> tradeProfit()throws SQLException {
        ProductTradeDao productTradeDao=new ProductTradeDaoImp();
        List<Integer> listProfit=productTradeDao.tradeProfit();
        return listProfit;
    }
}
