package org.osate.xtext.aadl2.properties.ui.linking;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.osate.aadl2.Aadl2Package;

public class PropertiesLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider{

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		EClass referenceType = context.getReference().getEReferenceType();
		String targetName = null;
		if (Aadl2Package.eINSTANCE.getAbstractNamedValue() == referenceType){
			targetName = "Property Constant, Property Definition, Enumeration or Unit literal";
			String msg = "Couldn't resolve reference to " + targetName + " '" + context.getLinkText() + "'." + " For classifier references use classifier( <ref> ).";
			return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC);
		}
		return super.getUnresolvedProxyMessage(context);
	}

}
