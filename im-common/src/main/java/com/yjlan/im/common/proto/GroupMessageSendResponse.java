// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: im.proto

package com.yjlan.im.common.proto;

/**
 * Protobuf type {@code GroupMessageSendResponse}
 */
public  final class GroupMessageSendResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:GroupMessageSendResponse)
    GroupMessageSendResponseOrBuilder {
  // Use GroupMessageSendResponse.newBuilder() to construct.
  private GroupMessageSendResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GroupMessageSendResponse() {
    code_ = 0;
    message_ = "";
    senderId_ = 0L;
    groupId_ = 0L;
    timestamp_ = 0L;
    receiverId_ = 0L;
    sendContent_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private GroupMessageSendResponse(
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

            code_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            message_ = s;
            break;
          }
          case 24: {

            senderId_ = input.readInt64();
            break;
          }
          case 32: {

            groupId_ = input.readInt64();
            break;
          }
          case 40: {

            timestamp_ = input.readInt64();
            break;
          }
          case 48: {

            receiverId_ = input.readInt64();
            break;
          }
          case 58: {
            java.lang.String s = input.readStringRequireUtf8();

            sendContent_ = s;
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
    return com.yjlan.im.common.proto.Im.internal_static_GroupMessageSendResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.yjlan.im.common.proto.Im.internal_static_GroupMessageSendResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.yjlan.im.common.proto.GroupMessageSendResponse.class, com.yjlan.im.common.proto.GroupMessageSendResponse.Builder.class);
  }

  public static final int CODE_FIELD_NUMBER = 1;
  private int code_;
  /**
   * <code>optional int32 code = 1;</code>
   */
  public int getCode() {
    return code_;
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object message_;
  /**
   * <code>optional string message = 2;</code>
   */
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>optional string message = 2;</code>
   */
  public com.google.protobuf.ByteString
      getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SENDERID_FIELD_NUMBER = 3;
  private long senderId_;
  /**
   * <code>optional int64 senderId = 3;</code>
   */
  public long getSenderId() {
    return senderId_;
  }

  public static final int GROUPID_FIELD_NUMBER = 4;
  private long groupId_;
  /**
   * <code>optional int64 groupId = 4;</code>
   */
  public long getGroupId() {
    return groupId_;
  }

  public static final int TIMESTAMP_FIELD_NUMBER = 5;
  private long timestamp_;
  /**
   * <code>optional int64 timestamp = 5;</code>
   */
  public long getTimestamp() {
    return timestamp_;
  }

  public static final int RECEIVERID_FIELD_NUMBER = 6;
  private long receiverId_;
  /**
   * <code>optional int64 receiverId = 6;</code>
   */
  public long getReceiverId() {
    return receiverId_;
  }

  public static final int SENDCONTENT_FIELD_NUMBER = 7;
  private volatile java.lang.Object sendContent_;
  /**
   * <code>optional string sendContent = 7;</code>
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
   * <code>optional string sendContent = 7;</code>
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
    if (code_ != 0) {
      output.writeInt32(1, code_);
    }
    if (!getMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
    }
    if (senderId_ != 0L) {
      output.writeInt64(3, senderId_);
    }
    if (groupId_ != 0L) {
      output.writeInt64(4, groupId_);
    }
    if (timestamp_ != 0L) {
      output.writeInt64(5, timestamp_);
    }
    if (receiverId_ != 0L) {
      output.writeInt64(6, receiverId_);
    }
    if (!getSendContentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 7, sendContent_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (code_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, code_);
    }
    if (!getMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, message_);
    }
    if (senderId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, senderId_);
    }
    if (groupId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, groupId_);
    }
    if (timestamp_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, timestamp_);
    }
    if (receiverId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(6, receiverId_);
    }
    if (!getSendContentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, sendContent_);
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
    if (!(obj instanceof com.yjlan.im.common.proto.GroupMessageSendResponse)) {
      return super.equals(obj);
    }
    com.yjlan.im.common.proto.GroupMessageSendResponse other = (com.yjlan.im.common.proto.GroupMessageSendResponse) obj;

    boolean result = true;
    result = result && (getCode()
        == other.getCode());
    result = result && getMessage()
        .equals(other.getMessage());
    result = result && (getSenderId()
        == other.getSenderId());
    result = result && (getGroupId()
        == other.getGroupId());
    result = result && (getTimestamp()
        == other.getTimestamp());
    result = result && (getReceiverId()
        == other.getReceiverId());
    result = result && getSendContent()
        .equals(other.getSendContent());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCode();
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    hash = (37 * hash) + SENDERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSenderId());
    hash = (37 * hash) + GROUPID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getGroupId());
    hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTimestamp());
    hash = (37 * hash) + RECEIVERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getReceiverId());
    hash = (37 * hash) + SENDCONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getSendContent().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.yjlan.im.common.proto.GroupMessageSendResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.yjlan.im.common.proto.GroupMessageSendResponse parseFrom(
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
  public static Builder newBuilder(com.yjlan.im.common.proto.GroupMessageSendResponse prototype) {
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
   * Protobuf type {@code GroupMessageSendResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:GroupMessageSendResponse)
      com.yjlan.im.common.proto.GroupMessageSendResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.yjlan.im.common.proto.Im.internal_static_GroupMessageSendResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.yjlan.im.common.proto.Im.internal_static_GroupMessageSendResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.yjlan.im.common.proto.GroupMessageSendResponse.class, com.yjlan.im.common.proto.GroupMessageSendResponse.Builder.class);
    }

    // Construct using com.yjlan.im.common.proto.GroupMessageSendResponse.newBuilder()
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
      code_ = 0;

      message_ = "";

      senderId_ = 0L;

      groupId_ = 0L;

      timestamp_ = 0L;

      receiverId_ = 0L;

      sendContent_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.yjlan.im.common.proto.Im.internal_static_GroupMessageSendResponse_descriptor;
    }

    public com.yjlan.im.common.proto.GroupMessageSendResponse getDefaultInstanceForType() {
      return com.yjlan.im.common.proto.GroupMessageSendResponse.getDefaultInstance();
    }

    public com.yjlan.im.common.proto.GroupMessageSendResponse build() {
      com.yjlan.im.common.proto.GroupMessageSendResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.yjlan.im.common.proto.GroupMessageSendResponse buildPartial() {
      com.yjlan.im.common.proto.GroupMessageSendResponse result = new com.yjlan.im.common.proto.GroupMessageSendResponse(this);
      result.code_ = code_;
      result.message_ = message_;
      result.senderId_ = senderId_;
      result.groupId_ = groupId_;
      result.timestamp_ = timestamp_;
      result.receiverId_ = receiverId_;
      result.sendContent_ = sendContent_;
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
      if (other instanceof com.yjlan.im.common.proto.GroupMessageSendResponse) {
        return mergeFrom((com.yjlan.im.common.proto.GroupMessageSendResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.yjlan.im.common.proto.GroupMessageSendResponse other) {
      if (other == com.yjlan.im.common.proto.GroupMessageSendResponse.getDefaultInstance()) return this;
      if (other.getCode() != 0) {
        setCode(other.getCode());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (other.getSenderId() != 0L) {
        setSenderId(other.getSenderId());
      }
      if (other.getGroupId() != 0L) {
        setGroupId(other.getGroupId());
      }
      if (other.getTimestamp() != 0L) {
        setTimestamp(other.getTimestamp());
      }
      if (other.getReceiverId() != 0L) {
        setReceiverId(other.getReceiverId());
      }
      if (!other.getSendContent().isEmpty()) {
        sendContent_ = other.sendContent_;
        onChanged();
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
      com.yjlan.im.common.proto.GroupMessageSendResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.yjlan.im.common.proto.GroupMessageSendResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int code_ ;
    /**
     * <code>optional int32 code = 1;</code>
     */
    public int getCode() {
      return code_;
    }
    /**
     * <code>optional int32 code = 1;</code>
     */
    public Builder setCode(int value) {
      
      code_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 code = 1;</code>
     */
    public Builder clearCode() {
      
      code_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object message_ = "";
    /**
     * <code>optional string message = 2;</code>
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string message = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string message = 2;</code>
     */
    public Builder setMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      message_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string message = 2;</code>
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <code>optional string message = 2;</code>
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      message_ = value;
      onChanged();
      return this;
    }

    private long senderId_ ;
    /**
     * <code>optional int64 senderId = 3;</code>
     */
    public long getSenderId() {
      return senderId_;
    }
    /**
     * <code>optional int64 senderId = 3;</code>
     */
    public Builder setSenderId(long value) {
      
      senderId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 senderId = 3;</code>
     */
    public Builder clearSenderId() {
      
      senderId_ = 0L;
      onChanged();
      return this;
    }

    private long groupId_ ;
    /**
     * <code>optional int64 groupId = 4;</code>
     */
    public long getGroupId() {
      return groupId_;
    }
    /**
     * <code>optional int64 groupId = 4;</code>
     */
    public Builder setGroupId(long value) {
      
      groupId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 groupId = 4;</code>
     */
    public Builder clearGroupId() {
      
      groupId_ = 0L;
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

    private long receiverId_ ;
    /**
     * <code>optional int64 receiverId = 6;</code>
     */
    public long getReceiverId() {
      return receiverId_;
    }
    /**
     * <code>optional int64 receiverId = 6;</code>
     */
    public Builder setReceiverId(long value) {
      
      receiverId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 receiverId = 6;</code>
     */
    public Builder clearReceiverId() {
      
      receiverId_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object sendContent_ = "";
    /**
     * <code>optional string sendContent = 7;</code>
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
     * <code>optional string sendContent = 7;</code>
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
     * <code>optional string sendContent = 7;</code>
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
     * <code>optional string sendContent = 7;</code>
     */
    public Builder clearSendContent() {
      
      sendContent_ = getDefaultInstance().getSendContent();
      onChanged();
      return this;
    }
    /**
     * <code>optional string sendContent = 7;</code>
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
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:GroupMessageSendResponse)
  }

  // @@protoc_insertion_point(class_scope:GroupMessageSendResponse)
  private static final com.yjlan.im.common.proto.GroupMessageSendResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.yjlan.im.common.proto.GroupMessageSendResponse();
  }

  public static com.yjlan.im.common.proto.GroupMessageSendResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GroupMessageSendResponse>
      PARSER = new com.google.protobuf.AbstractParser<GroupMessageSendResponse>() {
    public GroupMessageSendResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GroupMessageSendResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GroupMessageSendResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GroupMessageSendResponse> getParserForType() {
    return PARSER;
  }

  public com.yjlan.im.common.proto.GroupMessageSendResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

