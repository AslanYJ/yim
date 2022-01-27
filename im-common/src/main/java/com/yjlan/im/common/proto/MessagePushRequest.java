// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: im.proto

package com.yjlan.im.common.proto;

/**
 * Protobuf type {@code MessagePushRequest}
 */
public  final class MessagePushRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:MessagePushRequest)
    MessagePushRequestOrBuilder {
  // Use MessagePushRequest.newBuilder() to construct.
  private MessagePushRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessagePushRequest() {
    messageId_ = 0L;
    senderId_ = 0L;
    receiverId_ = 0L;
    sendContent_ = "";
    timestamp_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private MessagePushRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            messageId_ = input.readInt64();
            break;
          }
          case 16: {

            senderId_ = input.readInt64();
            break;
          }
          case 24: {

            receiverId_ = input.readInt64();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            sendContent_ = s;
            break;
          }
          case 40: {

            timestamp_ = input.readInt64();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.yjlan.im.common.proto.Im.internal_static_MessagePushRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.yjlan.im.common.proto.Im.internal_static_MessagePushRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.yjlan.im.common.proto.MessagePushRequest.class, com.yjlan.im.common.proto.MessagePushRequest.Builder.class);
  }

  public static final int MESSAGEID_FIELD_NUMBER = 1;
  private long messageId_;
  /**
   * <code>optional int64 messageId = 1;</code>
   */
  public long getMessageId() {
    return messageId_;
  }

  public static final int SENDERID_FIELD_NUMBER = 2;
  private long senderId_;
  /**
   * <code>optional int64 senderId = 2;</code>
   */
  public long getSenderId() {
    return senderId_;
  }

  public static final int RECEIVERID_FIELD_NUMBER = 3;
  private long receiverId_;
  /**
   * <code>optional int64 receiverId = 3;</code>
   */
  public long getReceiverId() {
    return receiverId_;
  }

  public static final int SENDCONTENT_FIELD_NUMBER = 4;
  private volatile java.lang.Object sendContent_;
  /**
   * <code>optional string sendContent = 4;</code>
   */
  public java.lang.String getSendContent() {
    java.lang.Object ref = sendContent_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      sendContent_ = s;
      return s;
    }
  }
  /**
   * <code>optional string sendContent = 4;</code>
   */
  public com.google.protobuf.ByteString
      getSendContentBytes() {
    java.lang.Object ref = sendContent_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      sendContent_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TIMESTAMP_FIELD_NUMBER = 5;
  private long timestamp_;
  /**
   * <code>optional int64 timestamp = 5;</code>
   */
  public long getTimestamp() {
    return timestamp_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (messageId_ != 0L) {
      output.writeInt64(1, messageId_);
    }
    if (senderId_ != 0L) {
      output.writeInt64(2, senderId_);
    }
    if (receiverId_ != 0L) {
      output.writeInt64(3, receiverId_);
    }
    if (!getSendContentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, sendContent_);
    }
    if (timestamp_ != 0L) {
      output.writeInt64(5, timestamp_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (messageId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, messageId_);
    }
    if (senderId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, senderId_);
    }
    if (receiverId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, receiverId_);
    }
    if (!getSendContentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, sendContent_);
    }
    if (timestamp_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, timestamp_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.yjlan.im.common.proto.MessagePushRequest)) {
      return super.equals(obj);
    }
    com.yjlan.im.common.proto.MessagePushRequest other = (com.yjlan.im.common.proto.MessagePushRequest) obj;

    boolean result = true;
    result = result && (getMessageId()
        == other.getMessageId());
    result = result && (getSenderId()
        == other.getSenderId());
    result = result && (getReceiverId()
        == other.getReceiverId());
    result = result && getSendContent()
        .equals(other.getSendContent());
    result = result && (getTimestamp()
        == other.getTimestamp());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + MESSAGEID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMessageId());
    hash = (37 * hash) + SENDERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSenderId());
    hash = (37 * hash) + RECEIVERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getReceiverId());
    hash = (37 * hash) + SENDCONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getSendContent().hashCode();
    hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTimestamp());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.yjlan.im.common.proto.MessagePushRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.yjlan.im.common.proto.MessagePushRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.MessagePushRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.yjlan.im.common.proto.MessagePushRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.MessagePushRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.yjlan.im.common.proto.MessagePushRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.MessagePushRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.yjlan.im.common.proto.MessagePushRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.MessagePushRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.yjlan.im.common.proto.MessagePushRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.yjlan.im.common.proto.MessagePushRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code MessagePushRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:MessagePushRequest)
      com.yjlan.im.common.proto.MessagePushRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.yjlan.im.common.proto.Im.internal_static_MessagePushRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.yjlan.im.common.proto.Im.internal_static_MessagePushRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.yjlan.im.common.proto.MessagePushRequest.class, com.yjlan.im.common.proto.MessagePushRequest.Builder.class);
    }

    // Construct using com.yjlan.im.common.proto.MessagePushRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      messageId_ = 0L;

      senderId_ = 0L;

      receiverId_ = 0L;

      sendContent_ = "";

      timestamp_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.yjlan.im.common.proto.Im.internal_static_MessagePushRequest_descriptor;
    }

    public com.yjlan.im.common.proto.MessagePushRequest getDefaultInstanceForType() {
      return com.yjlan.im.common.proto.MessagePushRequest.getDefaultInstance();
    }

    public com.yjlan.im.common.proto.MessagePushRequest build() {
      com.yjlan.im.common.proto.MessagePushRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.yjlan.im.common.proto.MessagePushRequest buildPartial() {
      com.yjlan.im.common.proto.MessagePushRequest result = new com.yjlan.im.common.proto.MessagePushRequest(this);
      result.messageId_ = messageId_;
      result.senderId_ = senderId_;
      result.receiverId_ = receiverId_;
      result.sendContent_ = sendContent_;
      result.timestamp_ = timestamp_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.yjlan.im.common.proto.MessagePushRequest) {
        return mergeFrom((com.yjlan.im.common.proto.MessagePushRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.yjlan.im.common.proto.MessagePushRequest other) {
      if (other == com.yjlan.im.common.proto.MessagePushRequest.getDefaultInstance()) return this;
      if (other.getMessageId() != 0L) {
        setMessageId(other.getMessageId());
      }
      if (other.getSenderId() != 0L) {
        setSenderId(other.getSenderId());
      }
      if (other.getReceiverId() != 0L) {
        setReceiverId(other.getReceiverId());
      }
      if (!other.getSendContent().isEmpty()) {
        sendContent_ = other.sendContent_;
        onChanged();
      }
      if (other.getTimestamp() != 0L) {
        setTimestamp(other.getTimestamp());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.yjlan.im.common.proto.MessagePushRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.yjlan.im.common.proto.MessagePushRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long messageId_ ;
    /**
     * <code>optional int64 messageId = 1;</code>
     */
    public long getMessageId() {
      return messageId_;
    }
    /**
     * <code>optional int64 messageId = 1;</code>
     */
    public Builder setMessageId(long value) {
      
      messageId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 messageId = 1;</code>
     */
    public Builder clearMessageId() {
      
      messageId_ = 0L;
      onChanged();
      return this;
    }

    private long senderId_ ;
    /**
     * <code>optional int64 senderId = 2;</code>
     */
    public long getSenderId() {
      return senderId_;
    }
    /**
     * <code>optional int64 senderId = 2;</code>
     */
    public Builder setSenderId(long value) {
      
      senderId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 senderId = 2;</code>
     */
    public Builder clearSenderId() {
      
      senderId_ = 0L;
      onChanged();
      return this;
    }

    private long receiverId_ ;
    /**
     * <code>optional int64 receiverId = 3;</code>
     */
    public long getReceiverId() {
      return receiverId_;
    }
    /**
     * <code>optional int64 receiverId = 3;</code>
     */
    public Builder setReceiverId(long value) {
      
      receiverId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 receiverId = 3;</code>
     */
    public Builder clearReceiverId() {
      
      receiverId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object sendContent_ = "";
    /**
     * <code>optional string sendContent = 4;</code>
     */
    public java.lang.String getSendContent() {
      java.lang.Object ref = sendContent_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sendContent_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string sendContent = 4;</code>
     */
    public com.google.protobuf.ByteString
        getSendContentBytes() {
      java.lang.Object ref = sendContent_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        sendContent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string sendContent = 4;</code>
     */
    public Builder setSendContent(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      sendContent_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string sendContent = 4;</code>
     */
    public Builder clearSendContent() {
      
      sendContent_ = getDefaultInstance().getSendContent();
      onChanged();
      return this;
    }
    /**
     * <code>optional string sendContent = 4;</code>
     */
    public Builder setSendContentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      sendContent_ = value;
      onChanged();
      return this;
    }

    private long timestamp_ ;
    /**
     * <code>optional int64 timestamp = 5;</code>
     */
    public long getTimestamp() {
      return timestamp_;
    }
    /**
     * <code>optional int64 timestamp = 5;</code>
     */
    public Builder setTimestamp(long value) {
      
      timestamp_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 timestamp = 5;</code>
     */
    public Builder clearTimestamp() {
      
      timestamp_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:MessagePushRequest)
  }

  // @@protoc_insertion_point(class_scope:MessagePushRequest)
  private static final com.yjlan.im.common.proto.MessagePushRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.yjlan.im.common.proto.MessagePushRequest();
  }

  public static com.yjlan.im.common.proto.MessagePushRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessagePushRequest>
      PARSER = new com.google.protobuf.AbstractParser<MessagePushRequest>() {
    public MessagePushRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new MessagePushRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MessagePushRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MessagePushRequest> getParserForType() {
    return PARSER;
  }

  public com.yjlan.im.common.proto.MessagePushRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

