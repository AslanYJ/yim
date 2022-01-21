package com.yjlan.im.common.protocol;

import io.netty.buffer.ByteBuf;

import com.yjlan.im.common.constants.Constant;

/**
 * @author yjlan
 * @version V1.0
 * @Description 请求头
 * @date 2022.01.21 10:26
 */
public final class MessageHeader {
    
    /**
     * 消息头长度
     */
    private int headerLength;
    
    /**
     * 版本
     */
    private int version;
    
    /**
     * 消息类型(详情看枚举)
     */
    private int messageType;
    
    /**
     * 请求顺序
     */
    private int sequence;
    
    public void setHeaderLength(int headerLength) {
        this.headerLength = headerLength;
    }
    
    public void setVersion(int version) {
        this.version = version;
    }
    
    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
    
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    
    public int getHeaderLength() {
        return headerLength;
    }
    
    public int getVersion() {
        return version;
    }
    
    public int getMessageType() {
        return messageType;
    }
    
    public int getSequence() {
        return sequence;
    }
    
    @Override
    public String toString() {
        return "MessageHeader{" +
                "headerLength=" + headerLength +
                ", version=" + version +
                ", messageType=" + messageType +
                ", sequence=" + sequence +
                '}';
    }
    
    /**
     * 请求体解码
     * @param byteBuf 数据
     */
    public void deCode(ByteBuf byteBuf) {
        this.headerLength = byteBuf.readInt();
        this.version = byteBuf.readInt();
        this.messageType = byteBuf.readInt();
        this.sequence = byteBuf.readInt();
    }
    
    /**
     * 请求体编码
     * @param byteBuf 数据
     */
    public void enCode(ByteBuf byteBuf) {
        byteBuf.writeInt(Constant.DEFAULT_MESSAGE_HEADER_SIZE);
        byteBuf.writeInt(version);
        byteBuf.writeInt(messageType);
        byteBuf.writeInt(sequence);
    }
}
