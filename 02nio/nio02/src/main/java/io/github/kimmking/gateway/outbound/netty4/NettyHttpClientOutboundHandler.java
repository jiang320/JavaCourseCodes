package io.github.kimmking.gateway.outbound.netty4;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <p>
 *     reference  :
 *     HJ43
 *    huyanatown

 * </p>

 */
public class NettyHttpClientOutboundHandler  extends ChannelInboundHandlerAdapter {

    private NettyHttpClient client;
    public NettyHttpClientOutboundHandler(String proxyServer){
        this.client= new NettyHttpClient(proxyServer);
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx)
            throws Exception {
        
        
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        
        
        
    }
}