package com.yjlan.im.common.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.yjlan.im.common.proto.AuthenticateRequest;

/**
 * @author yjlan
 * @version V1.0
 * @Description 消息父类
 * @date 2022.01.21 10:26
 */
public class MessageProtocol {
    
    /**
     * 请求头
     */
    private MessageHeader header;
    
    /**
     * 请求体
     */
    private MessageLite body;
    
    /**
     * 数据解码
     *
     * @param msg 数据
     */
    public void deCode(ByteBuf msg) throws InvalidProtocolBufferException {
        MessageHeader messageHeader = new MessageHeader();
        // 解码header
        messageHeader.deCode(msg);
        this.header = messageHeader;
        
        // 请求类型
        int messageType = header.getMessageType();
        final MessageLite bodyTypeByMsgType = MessageTypeManager.getBodyTypeByMsgType(messageType);
        
        final byte[] buffer;
        final int offset;
        // 总体长度
        final int length = msg.readableBytes();
        // 从堆缓冲区中读取
        if (msg.hasArray()) {
            buffer = msg.array();
            // 计算第一个字节的偏移量
            offset = msg.arrayOffset() + msg.readerIndex();
        } else {
            buffer = ByteBufUtil.getBytes(msg, msg.readerIndex(), length, false);
            offset = 0;
        }
        this.body = bodyTypeByMsgType.getParserForType().parseFrom(buffer,offset,length);
    }
    
    /**
     * 数据编码
     *
     * @param byteBuf 要发送的数据
     */
    public void enCode(ByteBuf byteBuf) {
        header.enCode(byteBuf);
        byteBuf.writeBytes(body.toByteArray());
    }
    
    public MessageHeader getHeader() {
        return header;
    }
    
    public void setHeader(MessageHeader header) {
        this.header = header;
    }
    
    public MessageLite getBody() {
        return body;
    }
    
    public void setBody(MessageLite body) {
        this.body = body;
    }
    
    public static void main(String[] args) throws InvalidProtocolBufferException {
        // 封装认证请求的消息体
        AuthenticateRequest request =
                AuthenticateRequest.newBuilder().setUid(123)
       .setToken("123KKK")
        .setTimestamp(System.currentTimeMillis()).build();
        
        final byte[] bytes = request.toByteArray();
    
        ByteBufAllocator allocator = ByteBufAllocator.DEFAULT;
        ByteBuf writeBuffer = allocator.buffer(16 + bytes.length);
        writeBuffer.writeInt(1);
        writeBuffer.writeInt(1);
        writeBuffer.writeInt(1);
        writeBuffer.writeInt(1);
        writeBuffer.writeBytes(bytes);
        
        MessageProtocol deCode = new MessageProtocol();
        deCode.deCode(writeBuffer);
        System.out.println(deCode.getBody().toString());
        System.out.println(deCode.getHeader().toString());
    }
}
