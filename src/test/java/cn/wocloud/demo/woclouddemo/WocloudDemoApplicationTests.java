package cn.wocloud.demo.woclouddemo;


import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;
import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
@Slf4j
@SpringBootTest
public class WocloudDemoApplicationTests {

    final Base64.Decoder decoder = Base64.getDecoder();
    final Base64.Encoder encoder = Base64.getEncoder();



	@Test
	public void test() {
        final String text = "字串文字";
        final byte[] textByte;
        try {

            textByte = text.getBytes("UTF-8");
            //编码
            final String encodedText = encoder.encodeToString(textByte);
            System.out.println(encodedText);
            //解码
            System.out.println(new String(decoder.decode(encodedText), "UTF-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


	}

    @Test
    public void download() {



    }




    @Test
    public void sgin2() {

        String sign;
        Map<String, String> map = Maps.newHashMap();
        //timestamp为毫秒数的字符串形式
        String timestamp = String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(timestamp);
        map.put("timestamp", timestamp);
        //path ="/resource/process"
        map.put("path", "/api/dia/woCloudQryPrice");
        map.put("version", "1.0.0");
        map.put("signMethod", "MD5");
        List<String> storedKeys = Arrays.stream(map.keySet().toArray(new String[]{})).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        String SK = "5E96CC8B9B784D04913AEB27AD99A489";
        String signSort = storedKeys.stream().map(key -> String.join("=", key, map.get(key)))
                .collect(Collectors.joining("&")).trim().concat("&" + SK);
        System.out.println(signSort);
        sign = DigestUtils.md5DigestAsHex(signSort.getBytes()).toUpperCase();
        System.out.println(sign);



    }


    /**
     * 吉林小程序询价
     */
    @Test
    public void woCloudQryPrice() {

        Map<String, String> map = Maps.newHashMapWithExpectedSize(2);
        String s = String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(s);
        //timestamp为毫秒数的字符串形式 String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli())
        map.put("timestamp",s);  //值应该为毫秒数的字符串形式
        map.put("path", "/api/dia/woCloudQryPrice");
        map.put("version", "1.0.0");
        map.put("signMethod", "MD5");
        List<String> storedKeys = Arrays.stream(map.keySet()
                .toArray(new String[]{}))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        final String sign = storedKeys.stream()
                .map(key -> String.join("=", key, map.get(key)))
                .collect(Collectors.joining("&")).trim()
                .concat("&5E2D17738C1041FB8AB7BDDBD0C7993D");
        System.out.println(sign);

        String signnew = DigestUtils.md5DigestAsHex(sign.getBytes()).toUpperCase();
        System.out.println(signnew);



        String urlParam="https://cucc.wocloud.cn/api/dia/woCloudQryPrice";
        String str = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(urlParam);
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("timestamp",s);
        httpPost.addHeader("appKey","90928BFDE42E44EDBCC29457748FC752");
        httpPost.addHeader("sign",signnew);
        httpPost.addHeader("version","1.0.0");
        httpPost.addHeader("signMethod","MD5");
        int CONNECTION_TIMEOUT = 20000;
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CONNECTION_TIMEOUT).setConnectTimeout(CONNECTION_TIMEOUT).setSocketTimeout(CONNECTION_TIMEOUT).build();
        try{
            httpPost.setConfig(requestConfig);
            String jsonparam ="{\"orderInfo\":{\"busiCode\":\"PROUCT_CREATE\",\"customerId\":\"468408065\",\"devCode\":\"3001779001\",\"loginName\":\"300ALY000121\",\"modifyTag\":\"X\",\"userId\":\"1310010155520185H\",\"acceptDepartId\":\"staff\",\"acceptStaffId\":\"000300A\"},\"orderProductPackages\":[{\"productPackageId\":47,\"productPackageName\":\"云服务器ECS●沃云公有云\",\"packageType\":\"9001\",\"packageCode\":\"9001\",\"packageBillType\":\"PrePaid\",\"count\":1,\"period\":\"12\",\"periodInMonths\":\"1\",\"packageTypeCata\":\"PROD\",\"sellCycleUnit\":\"MONTH\",\"orderSubs\":[{\"brandId\":8000,\"cityCode\":\"300\",\"count\":1,\"customerId\":\"468408065\",\"modifyTag\":\"X\",\"period\":\"12\",\"productId\":139,\"regionId\":\"cn-huhehaote-nebula-1\",\"serviceType\":9001,\"userId\":\"1310010155520185H\",\"orderProducts\":[{\"serviceType\":9001,\"productId\":139,\"productType\":1,\"productCata\":11115556,\"productName\":\"ECS●沃云公有云\",\"brandId\":8000,\"commodityId\":\"1910300000144006\",\"commodityName\":\"ecs\",\"period\":\"12\",\"count\":1,\"region\":\"cn-huhehaote-nebula-1\",\"zone\":\"cn-huhehaote-nebula-1a\",\"productBillType\":\"PrePaid\",\"productPrties\":[{\"propertyCode\":\"InstanceChargeType\",\"propertyValue\":\"PrePaid\",\"propertyName\":\"付费模式\",\"propertyValueShow\":\"包年包月\",\"status\":\"1\"},{\"propertyCode\":\"RegionId\",\"propertyValue\":\"cn-huhehaote-nebula-1\",\"propertyName\":\"地域\",\"propertyValueShow\":\"呼和浩特星云\",\"status\":\"1\"},{\"propertyCode\":\"ZoneId\",\"propertyValue\":\"cn-huhehaote-nebula-1a\",\"propertyName\":\"可用区\",\"propertyValueShow\":\"呼和浩特星云 可用区A\",\"status\":\"1\"},{\"propertyCode\":\"InstanceType\",\"propertyValue\":\"ecs.c5.16xlarge\",\"propertyName\":\"实例规格\",\"propertyValueShow\":\"64核128G\",\"status\":\"1\"},{\"propertyCode\":\"IoOptimized\",\"propertyValue\":\"optimized\",\"propertyName\":\"IO优化\",\"propertyValueShow\":\"是\",\"status\":\"1\"},{\"propertyCode\":\"InstanceNetworkType\",\"propertyValue\":\"VPC\",\"propertyName\":\"网络类型\",\"propertyValueShow\":\"专有网络\",\"status\":\"1\"},{\"propertyCode\":\"SecurityGroupId\",\"propertyValue\":\"\",\"propertyName\":\"安全组\",\"propertyValueShow\":\"默认安全组\",\"status\":\"1\"},{\"propertyCode\":\"InstanceTypeFamily\",\"propertyValue\":\"ecs.c5\",\"propertyName\":\"实例规格族\",\"propertyValueShow\":\"是\",\"status\":\"1\"},{\"propertyCode\":\"InternetChargeType\",\"propertyValue\":\"PayByBandwidth\",\"propertyName\":\"带宽计费模式\",\"propertyValueShow\":\"按固定带宽计费\",\"status\":\"1\"},{\"propertyCode\":\"InternetMaxBandwidthOut\",\"propertyValue\":50,\"propertyName\":\"带宽\",\"propertyValueShow\":\"1Mbit/s\",\"status\":\"1\"},{\"propertyCode\":\"Amount\",\"propertyValue\":1,\"propertyName\":\"购买数量\",\"propertyValueShow\":\"1个\",\"status\":\"1\"},{\"propertyCode\":\"AutoRenew\",\"propertyValue\":\"True\",\"propertyName\":\"自动续费\",\"propertyValueShow\":\"是\",\"status\":\"1\"},{\"propertyCode\":\"PeriodUnit\",\"propertyValue\":\"Month\",\"propertyName\":\"购买时长单位\",\"propertyValueShow\":\"月\",\"status\":\"1\"},{\"propertyCode\":\"Period\",\"propertyValue\":\"12\",\"propertyName\":\"购买时长\",\"propertyValueShow\":\"1年\",\"status\":\"1\"},{\"propertyCode\":\"VpcId\",\"propertyValue\":\"\",\"propertyName\":\"私有网络\",\"propertyValueShow\":\"默认专有网络\",\"status\":\"\"},{\"propertyCode\":\"VSwitchId\",\"propertyValue\":\"\",\"propertyName\":\"交换机\",\"propertyValueShow\":\"默认交换机\",\"status\":\"\"}]}],\"operatorId\":\"000300A\"},{\"brandId\":8000,\"cityCode\":\"300\",\"count\":1,\"customerId\":\"468408065\",\"modifyTag\":\"X\",\"period\":\"12\",\"productId\":140,\"regionId\":\"cn-huhehaote-nebula-1\",\"serviceType\":9025,\"userId\":\"1310010155520185H\",\"orderProducts\":[{\"serviceType\":9025,\"productId\":140,\"productType\":1,\"productCata\":11115557,\"productName\":\"BS●沃云公有云\",\"brandId\":8000,\"commodityId\":\"1910300000144006\",\"commodityName\":\"bs\",\"period\":\"12\",\"count\":1,\"region\":\"cn-huhehaote-nebula-1\",\"zone\":\"cn-huhehaote-nebula-1a\",\"productBillType\":\"PrePaid\",\"productPrties\":[{\"propertyCode\":\"billingMode\",\"propertyValue\":\"PrePaid\",\"propertyName\":\"付费模式\",\"propertyValueShow\":\"包年包月\",\"status\":\"1\"},{\"propertyCode\":\"RegionId\",\"propertyValue\":\"cn-huhehaote-nebula-1\",\"propertyName\":\"地域\",\"propertyValueShow\":\"呼和浩特星云\",\"status\":\"1\"},{\"propertyCode\":\"ZoneId\",\"propertyValue\":\"cn-huhehaote-nebula-1a\",\"propertyName\":\"可用区\",\"propertyValueShow\":\"呼和浩特星云 可用区A\",\"status\":\"1\"},{\"propertyCode\":\"Type\",\"propertyName\":\"Type\",\"propertyValue\":\"system\",\"propertyValueShow\":\"系统盘\",\"status\":\"1\"},{\"propertyCode\":\"DiskCategory\",\"propertyValue\":\"cloud_efficiency\",\"propertyName\":\"系统盘\",\"propertyValueShow\":\"高效云盘\",\"status\":\"1\"},{\"propertyCode\":\"Size\",\"propertyName\":\"系统盘大小\",\"propertyValue\":40,\"propertyValueShow\":\"40GiB\",\"status\":\"1\"},{\"propertyCode\":\"DiskChargeType\",\"propertyName\":\"付费类型\",\"propertyValue\":\"PrePaid\",\"propertyValueShow\":\"包年包月\",\"status\":\"1\"},{\"propertyCode\":\"ImageId\",\"propertyValue\":\"coreos_2303_4.0_x64_30G_alibase_20200217.vhd\",\"propertyName\":\"镜像\",\"propertyValueShow\":\"coreos_2303_4.0_x64_30G_alibase_20200217.vhd\",\"status\":\"1\"},{\"propertyCode\":\"ImageOs\",\"propertyName\":\"操作系统\",\"propertyValue\":\"linux\",\"propertyValueShow\":\"linux\",\"status\":\"1\"}]}],\"operatorId\":\"000300A\"},{\"brandId\":8000,\"cityCode\":\"300\",\"count\":1,\"customerId\":\"468408065\",\"modifyTag\":\"X\",\"period\":\"12\",\"productId\":140,\"regionId\":\"cn-huhehaote-nebula-1\",\"serviceType\":9025,\"userId\":\"1310010155520185H\",\"orderProducts\":[{\"serviceType\":9025,\"productId\":140,\"productType\":1,\"productCata\":11115557,\"productName\":\"BS●沃云公有云\",\"brandId\":8000,\"commodityId\":\"1910300000144006\",\"commodityName\":\"bs\",\"period\":\"12\",\"count\":1,\"region\":\"cn-huhehaote-nebula-1\",\"zone\":\"cn-huhehaote-nebula-1a\",\"productBillType\":\"PrePaid\",\"productPrties\":[{\"propertyCode\":\"billingMode\",\"propertyValue\":\"PrePaid\",\"propertyName\":\"付费模式\",\"propertyValueShow\":\"包年包月\",\"status\":\"1\"},{\"propertyCode\":\"RegionId\",\"propertyValue\":\"cn-huhehaote-nebula-1\",\"propertyName\":\"地域\",\"propertyValueShow\":\"呼和浩特星云\",\"status\":\"1\"},{\"propertyCode\":\"ZoneId\",\"propertyValue\":\"cn-huhehaote-nebula-1a\",\"propertyName\":\"可用区\",\"propertyValueShow\":\"呼和浩特星云 可用区A\",\"status\":\"1\"},{\"propertyCode\":\"Type\",\"propertyName\":\"Type\",\"propertyValue\":\"data\",\"propertyValueShow\":\"数据盘\",\"status\":\"1\"},{\"propertyCode\":\"DiskCategory\",\"propertyValue\":\"cloud_efficiency\",\"propertyName\":\"数据盘\",\"propertyValueShow\":\"高效云盘\",\"status\":\"1\"},{\"propertyCode\":\"Size\",\"propertyName\":\"数据盘大小\",\"propertyValue\":2000,\"propertyValueShow\":\"2000GiB\",\"status\":\"1\"},{\"propertyCode\":\"DiskChargeType\",\"propertyName\":\"付费类型\",\"propertyValue\":\"PrePaid\",\"propertyValueShow\":\"包年包月\",\"status\":\"1\"},{\"propertyCode\":\"ImageId\",\"propertyValue\":\"coreos_2303_4.0_x64_30G_alibase_20200217.vhd\",\"propertyName\":\"镜像\",\"propertyValueShow\":\"coreos_2303_4.0_x64_30G_alibase_20200217.vhd\",\"status\":\"1\"},{\"propertyCode\":\"ImageOs\",\"propertyName\":\"操作系统\",\"propertyValue\":\"linux\",\"propertyValueShow\":\"linux\",\"status\":\"1\"}]}],\"operatorId\":\"000300A\"}]}]}";
            StringEntity stringEntity = new StringEntity(jsonparam, Charset.forName("UTF-8"));
            httpPost.setEntity(stringEntity);
            long startTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
            System.out.println(startTime);
            HttpResponse response = httpClient.execute(httpPost);
            //读取服务器响应数据
            BufferedReader bufferedReader=null;

            if (response.getStatusLine().getStatusCode() == 200){
                bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                str = bufferedReader.readLine();
                log.info("返回结果："+str);
                System.out.println("返回结果："+str);
            }else{
                log.info("请求失败:"+response.getStatusLine().getStatusCode());
                System.out.println("请求失败:"+response.getStatusLine().getStatusCode());
            }
            long endTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
            System.out.println("接口调用消耗时间："+(endTime-startTime)+"ms");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                httpClient.close();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }

    }


    /**
     * 云市场产品查询 生产
     */
    @Test
    public void queryProductDetailInfo() {
        Map<String, String> map = Maps.newHashMapWithExpectedSize(2);
        String s = String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(s);
        //timestamp为毫秒数的字符串形式 String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli())
        map.put("timestamp",s);  //值应该为毫秒数的字符串形式
        map.put("path", "/api/market/commonProductController/queryProductDetailInfo");
        map.put("version", "1.0.0");
        map.put("signMethod", "MD5");
        List<String> storedKeys = Arrays.stream(map.keySet()
                .toArray(new String[]{}))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        final String sign = storedKeys.stream()
                .map(key -> String.join("=", key, map.get(key)))
                .collect(Collectors.joining("&")).trim()
                .concat("&B160BE7EC25847609F2AB506B6EBB564");
        System.out.println(sign);

        String signnew = DigestUtils.md5DigestAsHex(sign.getBytes()).toUpperCase();
        System.out.println(signnew);



        String urlParam="https://cucc.wocloud.cn/api/market/commonProductController/queryProductDetailInfo";
        String str = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(urlParam);
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("timestamp",s);
        httpPost.addHeader("appKey","907AB1E397ED44F7B97C36659E60E201");
        httpPost.addHeader("sign",signnew);
        httpPost.addHeader("version","1.0.0");
        httpPost.addHeader("signMethod","MD5");
        int CONNECTION_TIMEOUT = 20000;
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CONNECTION_TIMEOUT).setConnectTimeout(CONNECTION_TIMEOUT).setSocketTimeout(CONNECTION_TIMEOUT).build();
        try{
            httpPost.setConfig(requestConfig);
            String jsonparam ="{\"productClass\":\"WO_T\",\"requestType\":\"market\",\"supplierProductId\":\"9291\"}";
            StringEntity stringEntity = new StringEntity(jsonparam, Charset.forName("UTF-8"));
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost);
            //读取服务器响应数据
            BufferedReader bufferedReader=null;

            if (response.getStatusLine().getStatusCode() == 200){
                bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                str = bufferedReader.readLine();
                log.info("返回结果："+str);
                System.out.println("返回结果："+str);
            }else{
                log.info("请求失败:"+response.getStatusLine().getStatusCode());
                System.out.println("请求失败:"+response.getStatusLine().getStatusCode());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                httpClient.close();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }

    }



    /**
     * 云市场产品查询 测试
     */
    @Test
    public void queryProductDetailInfoceshi() {
        Map<String, String> map = Maps.newHashMapWithExpectedSize(2);
        String s = String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(s);
        //timestamp为毫秒数的字符串形式 String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli())
        map.put("timestamp",s);  //值应该为毫秒数的字符串形式
        map.put("path", "/api/market/commonProductController/queryProductDetailInfo");
        map.put("version", "1.0.0");
        map.put("signMethod", "MD5");
        List<String> storedKeys = Arrays.stream(map.keySet()
                .toArray(new String[]{}))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        final String sign = storedKeys.stream()
                .map(key -> String.join("=", key, map.get(key)))
                .collect(Collectors.joining("&")).trim()
                .concat("&B160BE7EC25847609F2AB506B6EBB564");
        System.out.println(sign);

        String signnew = DigestUtils.md5DigestAsHex(sign.getBytes()).toUpperCase();
        System.out.println(signnew);



        String urlParam="http://mpk.wocloud.cn/api/market/commonProductController/queryProductDetailInfo";
        String str = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(urlParam);
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("timestamp",s);
        httpPost.addHeader("appKey","907AB1E397ED44F7B97C36659E60E201");
        httpPost.addHeader("sign",signnew);
        httpPost.addHeader("version","1.0.0");
        httpPost.addHeader("signMethod","MD5");
        int CONNECTION_TIMEOUT = 20000;
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CONNECTION_TIMEOUT).setConnectTimeout(CONNECTION_TIMEOUT).setSocketTimeout(CONNECTION_TIMEOUT).build();
        try{
            httpPost.setConfig(requestConfig);
            String jsonparam ="{\"productClass\":\"HJ_A\",\"requestType\":\"market\",\"supplierProductId\":\"cmgj00042861\"}";
            StringEntity stringEntity = new StringEntity(jsonparam, Charset.forName("UTF-8"));
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost);
            //读取服务器响应数据
            BufferedReader bufferedReader=null;

            if (response.getStatusLine().getStatusCode() == 200){
                bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                str = bufferedReader.readLine();
                log.info("返回结果："+str);
                System.out.println("返回结果："+str);
            }else{
                log.info("请求失败:"+response.getStatusLine().getStatusCode());
                System.out.println("请求失败:"+response.getStatusLine().getStatusCode());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                httpClient.close();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }

    }



}
