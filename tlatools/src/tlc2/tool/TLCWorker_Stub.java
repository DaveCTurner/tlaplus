// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package tlc2.tool;

/**
 * 
 * @deprecated Not used
 * @version $Id$
 */
public final class TLCWorker_Stub
    extends java.rmi.server.RemoteStub
    implements tlc2.tool.TLCWorkerRMI, java.rmi.Remote
{
    private static final java.rmi.server.Operation[] operations = {
	new java.rmi.server.Operation("void exit()"),
	new java.rmi.server.Operation("java.lang.Object getNextStates(tlc2.tool.TLCState[])[]")
    };
    
    private static final long interfaceHash = -7211739593295767913L;
    
    private static final long serialVersionUID = 2;
    
    private static boolean useNewInvoke;
    private static java.lang.reflect.Method $method_exit_0;
    private static java.lang.reflect.Method $method_getNextStates_1;
    
    static {
	try {
	    java.rmi.server.RemoteRef.class.getMethod("invoke",
		new java.lang.Class[] {
		    java.rmi.Remote.class,
		    java.lang.reflect.Method.class,
		    java.lang.Object[].class,
		    long.class
		});
	    useNewInvoke = true;
	    $method_exit_0 = tlc2.tool.TLCWorkerRMI.class.getMethod("exit", new java.lang.Class[] {});
	    $method_getNextStates_1 = tlc2.tool.TLCWorkerRMI.class.getMethod("getNextStates", new java.lang.Class[] {tlc2.tool.TLCState[].class});
	} catch (java.lang.NoSuchMethodException e) {
	    useNewInvoke = false;
	}
    }
    
    // constructors
    public TLCWorker_Stub() {
	super();
    }
    public TLCWorker_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of exit()
    public void exit()
	throws java.io.IOException
    {
	try {
	    if (useNewInvoke) {
		ref.invoke(this, $method_exit_0, null, -6307240473358936408L);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 0, interfaceHash);
		ref.invoke(call);
		ref.done(call);
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.io.IOException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getNextStates(TLCState[])
    public java.lang.Object[] getNextStates(tlc2.tool.TLCState[] $param_arrayOf_TLCState_1)
	throws java.rmi.RemoteException, tlc2.tool.WorkerException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_getNextStates_1, new java.lang.Object[] {$param_arrayOf_TLCState_1}, 1512474148561500310L);
		return ((java.lang.Object[]) $result);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 1, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_arrayOf_TLCState_1);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		java.lang.Object[] $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = (java.lang.Object[]) in.readObject();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} catch (java.lang.ClassNotFoundException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (tlc2.tool.WorkerException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
