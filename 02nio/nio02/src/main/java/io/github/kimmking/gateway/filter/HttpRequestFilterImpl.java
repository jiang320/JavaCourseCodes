package io.github.kimmking.gateway.filter;


import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

/**
 * <p>
 *     dongjiang
 *     reference:
 *     HJ43
 *
 * </p>
 */
public class HttpRequestFilterImpl implements  HttpRequestFilter{

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        HttpMethod method = fullRequest.method();
        if(method.equals(HttpMethod.POST)){
            FullHttpRequest response =null;

            try{
                response = (FullHttpRequest) new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.METHOD_NOT_ALLOWED);
            }catch (Exception e){
                e.printStackTrace();
                response= (FullHttpRequest) new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.NO_CONTENT);
            }finally {
                if(fullRequest!=null){
                    if(!HttpUtil.isKeepAlive(fullRequest)){
                        ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                    }else {
                        ctx.write(response);
                    }
                }
                ctx.flush();
                ctx.close();
            }


        }
    }
}
