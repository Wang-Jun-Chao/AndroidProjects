/*___Generated_by_IDEA___*/

/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\admin\\IdeaProjects\\AndroidProjects\\061-支付小胖子\\src\\com\\itheima\\alipay\\PayInterface.aidl
 */
package com.itheima.alipay;
/**
 * Author: 鐜嬩繆瓒� 
 * Date: 2015-10-13
 * Time: 09:08
 * Declaration: All Rights Reserved !!!
 */
public interface PayInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.itheima.alipay.PayInterface
{
private static final java.lang.String DESCRIPTOR = "com.itheima.alipay.PayInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.itheima.alipay.PayInterface interface,
 * generating a proxy if needed.
 */
public static com.itheima.alipay.PayInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.itheima.alipay.PayInterface))) {
return ((com.itheima.alipay.PayInterface)iin);
}
return new com.itheima.alipay.PayInterface.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_pay:
{
data.enforceInterface(DESCRIPTOR);
this.pay();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.itheima.alipay.PayInterface
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void pay() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_pay, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_pay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void pay() throws android.os.RemoteException;
}
