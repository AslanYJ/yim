// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: im.proto

package com.yjlan.im.common.proto;

public final class Im {
  private Im() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AuthenticateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AuthenticateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AuthenticateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AuthenticateResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MessageSendRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MessageSendRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MessageSendResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MessageSendResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MessagePushRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MessagePushRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_MessagePushResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_MessagePushResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SendDelivererRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SendDelivererRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SendDelivererResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SendDelivererResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GroupMessageSendRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GroupMessageSendRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GroupMessageSendResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GroupMessageSendResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GroupMessagePushRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GroupMessagePushRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GroupMessagePushResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GroupMessagePushResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\010im.proto\"Z\n\023AuthenticateRequest\022\013\n\003uid" +
      "\030\001 \001(\003\022\r\n\005token\030\002 \001(\t\022\021\n\ttimestamp\030\003 \001(\003" +
      "\022\024\n\014instanceCode\030\004 \001(\t\"5\n\024AuthenticateRe" +
      "sponse\022\014\n\004code\030\001 \001(\005\022\017\n\007message\030\002 \001(\t\"O\n" +
      "\022MessageSendRequest\022\020\n\010senderId\030\001 \001(\003\022\022\n" +
      "\nreceiverId\030\002 \001(\003\022\023\n\013sendContent\030\003 \001(\t\"m" +
      "\n\023MessageSendResponse\022\014\n\004code\030\001 \001(\005\022\017\n\007m" +
      "essage\030\002 \001(\t\022\020\n\010senderId\030\003 \001(\003\022\022\n\nreceiv" +
      "erId\030\004 \001(\003\022\021\n\ttimestamp\030\005 \001(\003\"u\n\022Message" +
      "PushRequest\022\021\n\tmessageId\030\001 \001(\003\022\020\n\010sender",
      "Id\030\002 \001(\003\022\022\n\nreceiverId\030\003 \001(\003\022\023\n\013sendCont" +
      "ent\030\004 \001(\t\022\021\n\ttimestamp\030\005 \001(\003\"\202\001\n\023Message" +
      "PushResponse\022\014\n\004code\030\001 \001(\005\022\017\n\007message\030\002 " +
      "\001(\t\022\020\n\010senderId\030\003 \001(\003\022\022\n\nreceiverId\030\004 \001(" +
      "\003\022\023\n\013sendContent\030\005 \001(\t\022\021\n\ttimestamp\030\006 \001(" +
      "\003\",\n\024SendDelivererRequest\022\024\n\014instanceCod" +
      "e\030\001 \001(\t\"6\n\025SendDelivererResponse\022\014\n\004code" +
      "\030\001 \001(\005\022\017\n\007message\030\002 \001(\t\"d\n\027GroupMessageS" +
      "endRequest\022\020\n\010senderId\030\001 \001(\003\022\017\n\007groupId\030" +
      "\002 \001(\003\022\023\n\013sendContent\030\003 \001(\t\022\021\n\ttimeStamp\030",
      "\004 \001(\003\"\230\001\n\030GroupMessageSendResponse\022\014\n\004co" +
      "de\030\001 \001(\005\022\017\n\007message\030\002 \001(\t\022\020\n\010senderId\030\003 " +
      "\001(\003\022\017\n\007groupId\030\004 \001(\003\022\021\n\ttimestamp\030\005 \001(\003\022" +
      "\022\n\nreceiverId\030\006 \001(\003\022\023\n\013sendContent\030\007 \001(\t" +
      "\"w\n\027GroupMessagePushRequest\022\020\n\010senderId\030" +
      "\001 \001(\003\022\017\n\007groupId\030\002 \001(\003\022\021\n\treviverId\030\003 \001(" +
      "\003\022\023\n\013sendContent\030\004 \001(\t\022\021\n\ttimeStamp\030\005 \001(" +
      "\003\"\230\001\n\030GroupMessagePushResponse\022\014\n\004code\030\001" +
      " \001(\005\022\017\n\007message\030\002 \001(\t\022\017\n\007groupId\030\003 \001(\003\022\020" +
      "\n\010senderId\030\004 \001(\003\022\022\n\nreceiverId\030\005 \001(\003\022\023\n\013",
      "sendContent\030\006 \001(\t\022\021\n\ttimeStamp\030\007 \001(\003B\035\n\031" +
      "com.yjlan.im.common.protoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_AuthenticateRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_AuthenticateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AuthenticateRequest_descriptor,
        new java.lang.String[] { "Uid", "Token", "Timestamp", "InstanceCode", });
    internal_static_AuthenticateResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_AuthenticateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AuthenticateResponse_descriptor,
        new java.lang.String[] { "Code", "Message", });
    internal_static_MessageSendRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_MessageSendRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MessageSendRequest_descriptor,
        new java.lang.String[] { "SenderId", "ReceiverId", "SendContent", });
    internal_static_MessageSendResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_MessageSendResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MessageSendResponse_descriptor,
        new java.lang.String[] { "Code", "Message", "SenderId", "ReceiverId", "Timestamp", });
    internal_static_MessagePushRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_MessagePushRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MessagePushRequest_descriptor,
        new java.lang.String[] { "MessageId", "SenderId", "ReceiverId", "SendContent", "Timestamp", });
    internal_static_MessagePushResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_MessagePushResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_MessagePushResponse_descriptor,
        new java.lang.String[] { "Code", "Message", "SenderId", "ReceiverId", "SendContent", "Timestamp", });
    internal_static_SendDelivererRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_SendDelivererRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SendDelivererRequest_descriptor,
        new java.lang.String[] { "InstanceCode", });
    internal_static_SendDelivererResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_SendDelivererResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SendDelivererResponse_descriptor,
        new java.lang.String[] { "Code", "Message", });
    internal_static_GroupMessageSendRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_GroupMessageSendRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GroupMessageSendRequest_descriptor,
        new java.lang.String[] { "SenderId", "GroupId", "SendContent", "TimeStamp", });
    internal_static_GroupMessageSendResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_GroupMessageSendResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GroupMessageSendResponse_descriptor,
        new java.lang.String[] { "Code", "Message", "SenderId", "GroupId", "Timestamp", "ReceiverId", "SendContent", });
    internal_static_GroupMessagePushRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_GroupMessagePushRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GroupMessagePushRequest_descriptor,
        new java.lang.String[] { "SenderId", "GroupId", "ReviverId", "SendContent", "TimeStamp", });
    internal_static_GroupMessagePushResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_GroupMessagePushResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GroupMessagePushResponse_descriptor,
        new java.lang.String[] { "Code", "Message", "GroupId", "SenderId", "ReceiverId", "SendContent", "TimeStamp", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
