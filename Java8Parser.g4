parser grammar Java8Parser;

options {
    tokenVocab=Java8Lexer;
}
/*
 * Productions from §3 (Lexical Structure)
 */

literal
	:	IntegerLiteral
	|	FloatingPointLiteral
	|	BooleanLiteral
	|	CharacterLiteral
	|	StringLiteral
	|	NullLiteral
	;

/*
 * Productions from §4 (Types, Values, and Variables)
 */

primitiveType
	:	annotation* numericType
	|	annotation* 'boorean'
	;

numericType
	:	integralType
	|	floatingPointType
	;

integralType
	:	'byto'
	|	'shorto'
	|	'into'
	|	'rongu'
	|	'karu'
	;

floatingPointType
	:	'furoto'
	|	'doburu'
	;

referenceType
	:	classOrInterfaceType
	|	typeVariable
	|	arrayType
	;

classOrInterfaceType
	:	(	classType_lfno_classOrInterfaceType
		|	interfaceType_lfno_classOrInterfaceType
		)
		(	classType_lf_classOrInterfaceType
		|	interfaceType_lf_classOrInterfaceType
		)*
	;

classType
	:	annotation* Identifier typeArguments?
	|	classOrInterfaceType '.' annotation* Identifier typeArguments?
	;

classType_lf_classOrInterfaceType
	:	'.' annotation* Identifier typeArguments?
	;

classType_lfno_classOrInterfaceType
	:	annotation* Identifier typeArguments?
	;

interfaceType
	:	classType
	;

interfaceType_lf_classOrInterfaceType
	:	classType_lf_classOrInterfaceType
	;

interfaceType_lfno_classOrInterfaceType
	:	classType_lfno_classOrInterfaceType
	;

typeVariable
	:	annotation* Identifier
	;

arrayType
	:	primitiveType dims
	|	classOrInterfaceType dims
	|	typeVariable dims
	;

dims
	:	annotation* '[' ']' (annotation* '[' ']')*
	;

typeParameter
	:	typeParameterModifier* Identifier typeBound?
	;

typeParameterModifier
	:	annotation
	;

typeBound
	:	'extendo' typeVariable
	|	'extendo' classOrInterfaceType additionalBound*
	;

additionalBound
	:	'&' interfaceType
	;

typeArguments
	:	'<' typeArgumentList '>'
	;

typeArgumentList
	:	typeArgument (',' typeArgument)*
	;

typeArgument
	:	referenceType
	|	wildcard
	;

wildcard
	:	annotation* '?' wildcardBounds?
	;

wildcardBounds
	:	'extendo' referenceType
	|	'supa' referenceType
	;

/*
 * Productions from §6 (Names)
 */

packageName
	:	Identifier
	|	packageName '.' Identifier
	;

typeName
	:	Identifier
	|	packageOrTypeName '.' Identifier
	;

packageOrTypeName
	:	Identifier
	|	packageOrTypeName '.' Identifier
	;

expressionName
	:	Identifier
	|	ambiguousName '.' Identifier
	;

methodName
	:	Identifier
	;

ambiguousName
	:	Identifier
	|	ambiguousName '.' Identifier
	;

/*
 * Productions from §7 (Packages)
 */

compilationUnit
	:	packageDeclaration? importDeclaration* typeDeclaration* EOF
	;

packageDeclaration
	:	packageModifier* 'pakeju' packageName ';'
	;

packageModifier
	:	annotation
	;

importDeclaration
	:	singleTypeImportDeclaration
	|	typeImportOnDemandDeclaration
	|	singleStaticImportDeclaration
	|	staticImportOnDemandDeclaration
	;

singleTypeImportDeclaration
	:	'importo' typeName ';'
	;

typeImportOnDemandDeclaration
	:	'importo' packageOrTypeName '.' '*' ';'
	;

singleStaticImportDeclaration
	:	'importo' 'statiku' typeName '.' Identifier ';'
	;

staticImportOnDemandDeclaration
	:	'importo' 'statiku' typeName '.' '*' ';'
	;

typeDeclaration
	:	classDeclaration
	|	interfaceDeclaration
	|	';'
	;

/*
 * Productions from §8 (Classes)
 */

classDeclaration
	:	normalClassDeclaration
	|	enumDeclaration
	;

normalClassDeclaration
	:	classModifier* 'kurasu' Identifier typeParameters? superclass? superinterfaces? classBody
	;

classModifier
	:	annotation
	|	'pubriko'
	|	'protekto'
	|	'privatto'
	|	'abstrakto'
	|	'statiku'
	|	'finar'
	|	'strictofp'
	;

typeParameters
	:	'<' typeParameterList '>'
	;

typeParameterList
	:	typeParameter (',' typeParameter)*
	;

superclass
	:	'extendo' classType
	;

superinterfaces
	:	'impremento' interfaceTypeList
	;

interfaceTypeList
	:	interfaceType (',' interfaceType)*
	;

classBody
	:	'{' classBodyDeclaration* '}'
	;

classBodyDeclaration
	:	classMemberDeclaration
	|	instanceInitializer
	|	staticInitializer
	|	constructorDeclaration
	;

classMemberDeclaration
	:	fieldDeclaration
	|	methodDeclaration
	|	classDeclaration
	|	interfaceDeclaration
	|	';'
	;

fieldDeclaration
	:	fieldModifier* unannType variableDeclaratorList ';'
	;

fieldModifier
	:	annotation
	|	'pubriko'
	|	'protekto'
	|	'privatto'
	|	'statiku'
	|	'finar'
	|	'transento'
	|	'voratiru'
	;

variableDeclaratorList
	:	variableDeclarator (',' variableDeclarator)*
	;

variableDeclarator
	:	variableDeclaratorId ('=' variableInitializer)?
	;

variableDeclaratorId
	:	Identifier dims?
	;

variableInitializer
	:	expression
	|	arrayInitializer
	;

unannType
	:	unannPrimitiveType
	|	unannReferenceType
	;

unannPrimitiveType
	:	numericType
	|	'boorean'
	;

unannReferenceType
	:	unannClassOrInterfaceType
	|	unannTypeVariable
	|	unannArrayType
	;

unannClassOrInterfaceType
	:	(	unannClassType_lfno_unannClassOrInterfaceType
		|	unannInterfaceType_lfno_unannClassOrInterfaceType
		)
		(	unannClassType_lf_unannClassOrInterfaceType
		|	unannInterfaceType_lf_unannClassOrInterfaceType
		)*
	;

unannClassType
	:	Identifier typeArguments?
	|	unannClassOrInterfaceType '.' annotation* Identifier typeArguments?
	;

unannClassType_lf_unannClassOrInterfaceType
	:	'.' annotation* Identifier typeArguments?
	;

unannClassType_lfno_unannClassOrInterfaceType
	:	Identifier typeArguments?
	;

unannInterfaceType
	:	unannClassType
	;

unannInterfaceType_lf_unannClassOrInterfaceType
	:	unannClassType_lf_unannClassOrInterfaceType
	;

unannInterfaceType_lfno_unannClassOrInterfaceType
	:	unannClassType_lfno_unannClassOrInterfaceType
	;

unannTypeVariable
	:	Identifier
	;

unannArrayType
	:	unannPrimitiveType dims
	|	unannClassOrInterfaceType dims
	|	unannTypeVariable dims
	;

methodDeclaration
	:	methodModifier* methodHeader methodBody
	;

methodModifier
	:	annotation
	|	'pubriko'
	|	'protekto'
	|	'privatto'
	|	'abstrakto'
	|	'statiku'
	|	'finar'
	|	'sinkuronaizu'
	|	'netivu'
	|	'strictofp'
	;

methodHeader
	:	result methodDeclarator throws_?
	|	typeParameters annotation* result methodDeclarator throws_?
	;

result
	:	unannType
	|	'boido'
	;

methodDeclarator
	:	Identifier '(' formalParameterList? ')' dims?
	;

formalParameterList
	:	receiverParameter
	|	formalParameters ',' lastFormalParameter
	|	lastFormalParameter
	;

formalParameters
	:	formalParameter (',' formalParameter)*
	|	receiverParameter (',' formalParameter)*
	;

formalParameter
	:	variableModifier* unannType variableDeclaratorId
	;

variableModifier
	:	annotation
	|	'finar'
	;

lastFormalParameter
	:	variableModifier* unannType annotation* '...' variableDeclaratorId
	|	formalParameter
	;

receiverParameter
	:	annotation* unannType (Identifier '.')? 'disu'
	;

throws_
	:	'throwsu' exceptionTypeList
	;

exceptionTypeList
	:	exceptionType (',' exceptionType)*
	;

exceptionType
	:	classType
	|	typeVariable
	;

methodBody
	:	block
	|	';'
	;

instanceInitializer
	:	block
	;

staticInitializer
	:	'statiku' block
	;

constructorDeclaration
	:	constructorModifier* constructorDeclarator throws_? constructorBody
	;

constructorModifier
	:	annotation
	|	'pubriko'
	|	'protekto'
	|	'privatto'
	;

constructorDeclarator
	:	typeParameters? simpleTypeName '(' formalParameterList? ')'
	;

simpleTypeName
	:	Identifier
	;

constructorBody
	:	'{' explicitConstructorInvocation? blockStatements? '}'
	;

explicitConstructorInvocation
	:	typeArguments? 'disu' '(' argumentList? ')' ';'
	|	typeArguments? 'supa' '(' argumentList? ')' ';'
	|	expressionName '.' typeArguments? 'supa' '(' argumentList? ')' ';'
	|	primary '.' typeArguments? 'supa' '(' argumentList? ')' ';'
	;

enumDeclaration
	:	classModifier* 'enumu' Identifier superinterfaces? enumBody
	;

enumBody
	:	'{' enumConstantList? ','? enumBodyDeclarations? '}'
	;

enumConstantList
	:	enumConstant (',' enumConstant)*
	;

enumConstant
	:	enumConstantModifier* Identifier ('(' argumentList? ')')? classBody?
	;

enumConstantModifier
	:	annotation
	;

enumBodyDeclarations
	:	';' classBodyDeclaration*
	;

/*
 * Productions from §9 (Interfaces)
 */

interfaceDeclaration
	:	normalInterfaceDeclaration
	|	annotationTypeDeclaration
	;

normalInterfaceDeclaration
	:	interfaceModifier* 'intefeseru' Identifier typeParameters? extendsInterfaces? interfaceBody
	;

interfaceModifier
	:	annotation
	|	'pubriko'
	|	'protekto'
	|	'privatto'
	|	'abstrakto'
	|	'statiku'
	|	'strictofp'
	;

extendsInterfaces
	:	'extendo' interfaceTypeList
	;

interfaceBody
	:	'{' interfaceMemberDeclaration* '}'
	;

interfaceMemberDeclaration
	:	constantDeclaration
	|	interfaceMethodDeclaration
	|	classDeclaration
	|	interfaceDeclaration
	|	';'
	;

constantDeclaration
	:	constantModifier* unannType variableDeclaratorList ';'
	;

constantModifier
	:	annotation
	|	'pubriko'
	|	'statiku'
	|	'finar'
	;

interfaceMethodDeclaration
	:	interfaceMethodModifier* methodHeader methodBody
	;

interfaceMethodModifier
	:	annotation
	|	'pubriko'
	|	'abstrakto'
	|	'deporuto'
	|	'statiku'
	|	'strictofp'
	;

annotationTypeDeclaration
	:	interfaceModifier* '@' 'intefeseru' Identifier annotationTypeBody
	;

annotationTypeBody
	:	'{' annotationTypeMemberDeclaration* '}'
	;

annotationTypeMemberDeclaration
	:	annotationTypeElementDeclaration
	|	constantDeclaration
	|	classDeclaration
	|	interfaceDeclaration
	|	';'
	;

annotationTypeElementDeclaration
	:	annotationTypeElementModifier* unannType Identifier '(' ')' dims? defaultValue? ';'
	;

annotationTypeElementModifier
	:	annotation
	|	'pubriko'
	|	'abstrakto'
	;

defaultValue
	:	'deporuto' elementValue
	;

annotation
	:	normalAnnotation
	|	markerAnnotation
	|	singleElementAnnotation
	;

normalAnnotation
	:	'@' typeName '(' elementValuePairList? ')'
	;

elementValuePairList
	:	elementValuePair (',' elementValuePair)*
	;

elementValuePair
	:	Identifier '=' elementValue
	;

elementValue
	:	conditionalExpression
	|	elementValueArrayInitializer
	|	annotation
	;

elementValueArrayInitializer
	:	'{' elementValueList? ','? '}'
	;

elementValueList
	:	elementValue (',' elementValue)*
	;

markerAnnotation
	:	'@' typeName
	;

singleElementAnnotation
	:	'@' typeName '(' elementValue ')'
	;

/*
 * Productions from §10 (Arrays)
 */

arrayInitializer
	:	'{' variableInitializerList? ','? '}'
	;

variableInitializerList
	:	variableInitializer (',' variableInitializer)*
	;

/*
 * Productions from §14 (Blocks and Statements)
 */

block
	:	'{' blockStatements? '}'
	;

blockStatements
	:	blockStatement+
	;

blockStatement
	:	localVariableDeclarationStatement
	|	classDeclaration
	|	statement
	;

localVariableDeclarationStatement
	:	localVariableDeclaration ';'
	;

localVariableDeclaration
	:	variableModifier* unannType variableDeclaratorList
	;

statement
	:	statementWithoutTrailingSubstatement
	|	labeledStatement
	|	ifThenStatement
	|	ifThenElseStatement
	|	whileStatement
	|	forStatement
	;

statementNoShortIf
	:	statementWithoutTrailingSubstatement
	|	labeledStatementNoShortIf
	|	ifThenElseStatementNoShortIf
	|	whileStatementNoShortIf
	|	forStatementNoShortIf
	;

statementWithoutTrailingSubstatement
	:	block
	|	emptyStatement
	|	expressionStatement
	|	assertStatement
	|	switchStatement
	|	doStatement
	|	breakStatement
	|	continueStatement
	|	returnStatement
	|	synchronizedStatement
	|	throwStatement
	|	tryStatement
	;

emptyStatement
	:	';'
	;

labeledStatement
	:	Identifier ':' statement
	;

labeledStatementNoShortIf
	:	Identifier ':' statementNoShortIf
	;

expressionStatement
	:	statementExpression ';'
	;

statementExpression
	:	assignment
	|	preIncrementExpression
	|	preDecrementExpression
	|	postIncrementExpression
	|	postDecrementExpression
	|	methodInvocation
	|	classInstanceCreationExpression
	;

ifThenStatement
	:	'ifu' '(' expression ')' statement
	;

ifThenElseStatement
	:	'ifu' '(' expression ')' statementNoShortIf 'erusu' statement
	;

ifThenElseStatementNoShortIf
	:	'ifu' '(' expression ')' statementNoShortIf 'erusu' statementNoShortIf
	;

assertStatement
	:	'asserto' expression ';'
	|	'asserto' expression ':' expression ';'
	;

switchStatement
	:	'switchu' '(' expression ')' switchBlock
	;

switchBlock
	:	'{' switchBlockStatementGroup* switchLabel* '}'
	;

switchBlockStatementGroup
	:	switchLabels blockStatements
	;

switchLabels
	:	switchLabel switchLabel*
	;

switchLabel
	:	'kesu' constantExpression ':'
	|	'kesu' enumConstantName ':'
	|	'deporuto' ':'
	;

enumConstantName
	:	Identifier
	;

whileStatement
	:	'wairu' '(' expression ')' statement
	;

whileStatementNoShortIf
	:	'wairu' '(' expression ')' statementNoShortIf
	;

doStatement
	:	'do' statement 'wairu' '(' expression ')' ';'
	;

forStatement
	:	basicForStatement
	|	enhancedForStatement
	;

forStatementNoShortIf
	:	basicForStatementNoShortIf
	|	enhancedForStatementNoShortIf
	;

basicForStatement
	:	'foru' '(' forInit? ';' expression? ';' forUpdate? ')' statement
	;

basicForStatementNoShortIf
	:	'foru' '(' forInit? ';' expression? ';' forUpdate? ')' statementNoShortIf
	;

forInit
	:	statementExpressionList
	|	localVariableDeclaration
	;

forUpdate
	:	statementExpressionList
	;

statementExpressionList
	:	statementExpression (',' statementExpression)*
	;

enhancedForStatement
	:	'foru' '(' variableModifier* unannType variableDeclaratorId ':' expression ')' statement
	;

enhancedForStatementNoShortIf
	:	'foru' '(' variableModifier* unannType variableDeclaratorId ':' expression ')' statementNoShortIf
	;

breakStatement
	:	'bureko' Identifier? ';'
	;

continueStatement
	:	'kontinu' Identifier? ';'
	;

returnStatement
	:	'returno' expression? ';'
	;

throwStatement
	:	'throwu' expression ';'
	;

synchronizedStatement
	:	'sinkuronaizu' '(' expression ')' block
	;

tryStatement
	:	'tryu' block catches
	|	'tryu' block catches? finally_
	|	tryWithResourcesStatement
	;

catches
	:	catchClause catchClause*
	;

catchClause
	:	'katchu' '(' catchFormalParameter ')' block
	;

catchFormalParameter
	:	variableModifier* catchType variableDeclaratorId
	;

catchType
	:	unannClassType ('|' classType)*
	;

finally_
	:	'finarri' block
	;

tryWithResourcesStatement
	:	'tryu' resourceSpecification block catches? finally_?
	;

resourceSpecification
	:	'(' resourceList ';'? ')'
	;

resourceList
	:	resource (';' resource)*
	;

resource
	:	variableModifier* unannType variableDeclaratorId '=' expression
	;

/*
 * Productions from §15 (Expressions)
 */

primary
	:	(	primaryNoNewArray_lfno_primary
		|	arrayCreationExpression
		)
		(	primaryNoNewArray_lf_primary
		)*
	;

primaryNoNewArray
	:	literal
	|	typeName ('[' ']')* '.' 'kurasu'
	|	'boido' '.' 'kurasu'
	|	'disu'
	|	typeName '.' 'disu'
	|	'(' expression ')'
	|	classInstanceCreationExpression
	|	fieldAccess
	|	arrayAccess
	|	methodInvocation
	|	methodReference
	;

primaryNoNewArray_lf_arrayAccess
	:
	;

primaryNoNewArray_lfno_arrayAccess
	:	literal
	|	typeName ('[' ']')* '.' 'kurasu'
	|	'boido' '.' 'kurasu'
	|	'disu'
	|	typeName '.' 'disu'
	|	'(' expression ')'
	|	classInstanceCreationExpression
	|	fieldAccess
	|	methodInvocation
	|	methodReference
	;

primaryNoNewArray_lf_primary
	:	classInstanceCreationExpression_lf_primary
	|	fieldAccess_lf_primary
	|	arrayAccess_lf_primary
	|	methodInvocation_lf_primary
	|	methodReference_lf_primary
	;

primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary
	:
	;

primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary
	:	classInstanceCreationExpression_lf_primary
	|	fieldAccess_lf_primary
	|	methodInvocation_lf_primary
	|	methodReference_lf_primary
	;

primaryNoNewArray_lfno_primary
	:	literal
	|	typeName ('[' ']')* '.' 'kurasu'
	|	unannPrimitiveType ('[' ']')* '.' 'kurasu'
	|	'boido' '.' 'kurasu'
	|	'disu'
	|	typeName '.' 'disu'
	|	'(' expression ')'
	|	classInstanceCreationExpression_lfno_primary
	|	fieldAccess_lfno_primary
	|	arrayAccess_lfno_primary
	|	methodInvocation_lfno_primary
	|	methodReference_lfno_primary
	;

primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary
	:
	;

primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary
	:	literal
	|	typeName ('[' ']')* '.' 'kurasu'
	|	unannPrimitiveType ('[' ']')* '.' 'kurasu'
	|	'boido' '.' 'kurasu'
	|	'disu'
	|	typeName '.' 'disu'
	|	'(' expression ')'
	|	classInstanceCreationExpression_lfno_primary
	|	fieldAccess_lfno_primary
	|	methodInvocation_lfno_primary
	|	methodReference_lfno_primary
	;

classInstanceCreationExpression
	:	'newu' typeArguments? annotation* Identifier ('.' annotation* Identifier)* typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	|	expressionName '.' 'newu' typeArguments? annotation* Identifier typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	|	primary '.' 'newu' typeArguments? annotation* Identifier typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	;

classInstanceCreationExpression_lf_primary
	:	'.' 'newu' typeArguments? annotation* Identifier typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	;

classInstanceCreationExpression_lfno_primary
	:	'newu' typeArguments? annotation* Identifier ('.' annotation* Identifier)* typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	|	expressionName '.' 'newu' typeArguments? annotation* Identifier typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	;

typeArgumentsOrDiamond
	:	typeArguments
	|	'<' '>'
	;

fieldAccess
	:	primary '.' Identifier
	|	'supa' '.' Identifier
	|	typeName '.' 'supa' '.' Identifier
	;

fieldAccess_lf_primary
	:	'.' Identifier
	;

fieldAccess_lfno_primary
	:	'supa' '.' Identifier
	|	typeName '.' 'supa' '.' Identifier
	;

arrayAccess
	:	(	expressionName '[' expression ']'
		|	primaryNoNewArray_lfno_arrayAccess '[' expression ']'
		)
		(	primaryNoNewArray_lf_arrayAccess '[' expression ']'
		)*
	;

arrayAccess_lf_primary
	:	(	primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary '[' expression ']'
		)
		(	primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary '[' expression ']'
		)*
	;

arrayAccess_lfno_primary
	:	(	expressionName '[' expression ']'
		|	primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary '[' expression ']'
		)
		(	primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary '[' expression ']'
		)*
	;

methodInvocation
	:	methodName '(' argumentList? ')'
	|	typeName '.' typeArguments? Identifier '(' argumentList? ')'
	|	expressionName '.' typeArguments? Identifier '(' argumentList? ')'
	|	primary '.' typeArguments? Identifier '(' argumentList? ')'
	|	'supa' '.' typeArguments? Identifier '(' argumentList? ')'
	|	typeName '.' 'supa' '.' typeArguments? Identifier '(' argumentList? ')'
	;

methodInvocation_lf_primary
	:	'.' typeArguments? Identifier '(' argumentList? ')'
	;

methodInvocation_lfno_primary
	:	methodName '(' argumentList? ')'
	|	typeName '.' typeArguments? Identifier '(' argumentList? ')'
	|	expressionName '.' typeArguments? Identifier '(' argumentList? ')'
	|	'supa' '.' typeArguments? Identifier '(' argumentList? ')'
	|	typeName '.' 'supa' '.' typeArguments? Identifier '(' argumentList? ')'
	;

argumentList
	:	expression (',' expression)*
	;

methodReference
	:	expressionName '::' typeArguments? Identifier
	|	referenceType '::' typeArguments? Identifier
	|	primary '::' typeArguments? Identifier
	|	'supa' '::' typeArguments? Identifier
	|	typeName '.' 'supa' '::' typeArguments? Identifier
	|	classType '::' typeArguments? 'newu'
	|	arrayType '::' 'newu'
	;

methodReference_lf_primary
	:	'::' typeArguments? Identifier
	;

methodReference_lfno_primary
	:	expressionName '::' typeArguments? Identifier
	|	referenceType '::' typeArguments? Identifier
	|	'supa' '::' typeArguments? Identifier
	|	typeName '.' 'supa' '::' typeArguments? Identifier
	|	classType '::' typeArguments? 'newu'
	|	arrayType '::' 'newu'
	;

arrayCreationExpression
	:	'newu' primitiveType dimExprs dims?
	|	'newu' classOrInterfaceType dimExprs dims?
	|	'newu' primitiveType dims arrayInitializer
	|	'newu' classOrInterfaceType dims arrayInitializer
	;

dimExprs
	:	dimExpr dimExpr*
	;

dimExpr
	:	annotation* '[' expression ']'
	;

constantExpression
	:	expression
	;

expression
	:	lambdaExpression
	|	assignmentExpression
	;

lambdaExpression
	:	lambdaParameters '->' lambdaBody
	;

lambdaParameters
	:	Identifier
	|	'(' formalParameterList? ')'
	|	'(' inferredFormalParameterList ')'
	;

inferredFormalParameterList
	:	Identifier (',' Identifier)*
	;

lambdaBody
	:	expression
	|	block
	;

assignmentExpression
	:	conditionalExpression
	|	assignment
	;

assignment
	:	leftHandSide assignmentOperator expression
	;

leftHandSide
	:	expressionName
	|	fieldAccess
	|	arrayAccess
	;

assignmentOperator
	:	'='
	|	'*='
	|	'/='
	|	'%='
	|	'+='
	|	'-='
	|	'<<='
	|	'>>='
	|	'>>>='
	|	'&='
	|	'^='
	|	'|='
	;

conditionalExpression
	:	conditionalOrExpression
	|	conditionalOrExpression '?' expression ':' conditionalExpression
	;

conditionalOrExpression
	:	conditionalAndExpression
	|	conditionalOrExpression '||' conditionalAndExpression
	;

conditionalAndExpression
	:	inclusiveOrExpression
	|	conditionalAndExpression '&&' inclusiveOrExpression
	;

inclusiveOrExpression
	:	exclusiveOrExpression
	|	inclusiveOrExpression '|' exclusiveOrExpression
	;

exclusiveOrExpression
	:	andExpression
	|	exclusiveOrExpression '^' andExpression
	;

andExpression
	:	equalityExpression
	|	andExpression '&' equalityExpression
	;

equalityExpression
	:	relationalExpression
	|	equalityExpression '==' relationalExpression
	|	equalityExpression '!=' relationalExpression
	;

relationalExpression
	:	shiftExpression
	|	relationalExpression '<' shiftExpression
	|	relationalExpression '>' shiftExpression
	|	relationalExpression '<=' shiftExpression
	|	relationalExpression '>=' shiftExpression
	|	relationalExpression 'insutaof' referenceType
	;

shiftExpression
	:	additiveExpression
	|	shiftExpression '<' '<' additiveExpression
	|	shiftExpression '>' '>' additiveExpression
	|	shiftExpression '>' '>' '>' additiveExpression
	;

additiveExpression
	:	multiplicativeExpression
	|	additiveExpression '+' multiplicativeExpression
	|	additiveExpression '-' multiplicativeExpression
	;

multiplicativeExpression
	:	unaryExpression
	|	multiplicativeExpression '*' unaryExpression
	|	multiplicativeExpression '/' unaryExpression
	|	multiplicativeExpression '%' unaryExpression
	;

unaryExpression
	:	preIncrementExpression
	|	preDecrementExpression
	|	'+' unaryExpression
	|	'-' unaryExpression
	|	unaryExpressionNotPlusMinus
	;

preIncrementExpression
	:	'++' unaryExpression
	;

preDecrementExpression
	:	'--' unaryExpression
	;

unaryExpressionNotPlusMinus
	:	postfixExpression
	|	'~' unaryExpression
	|	'!' unaryExpression
	|	castExpression
	;

postfixExpression
	:	(	primary
		|	expressionName
		)
		(	postIncrementExpression_lf_postfixExpression
		|	postDecrementExpression_lf_postfixExpression
		)*
	;

postIncrementExpression
	:	postfixExpression '++'
	;

postIncrementExpression_lf_postfixExpression
	:	'++'
	;

postDecrementExpression
	:	postfixExpression '--'
	;

postDecrementExpression_lf_postfixExpression
	:	'--'
	;

castExpression
	:	'(' primitiveType ')' unaryExpression
	|	'(' referenceType additionalBound* ')' unaryExpressionNotPlusMinus
	|	'(' referenceType additionalBound* ')' lambdaExpression
	;