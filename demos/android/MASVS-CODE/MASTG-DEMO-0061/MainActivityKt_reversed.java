package org.owasp.mastestapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0001X\u008a\u008e\u0002"}, d2 = {"MASTG_TEXT_TAG", "", "MainScreen", "", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "displayString"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainActivityKt {
    public static final String MASTG_TEXT_TAG = "mastgTestText";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainScreen$lambda$6(int i, Composer composer, int i2) {
        MainScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MainScreen(Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(2010408835);
        ComposerKt.sourceInformation($composer2, "C(MainScreen)37@1171L63,38@1266L7,50@1613L280,41@1323L570:MainActivity.kt#vyvp3i");
        if ($changed != 0 || !$composer2.getSkipping()) {
            $composer2.startReplaceGroup(1922816064);
            ComposerKt.sourceInformation($composer2, "CC(remember):MainActivity.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Click \"Start\" to run the test.", null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState displayString$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Context context = (Context) objConsume;
            final MastgTest mastgTestClass = new MastgTest(context);
            BaseScreenKt.BaseScreen(new Function0() { // from class: org.owasp.mastestapp.MainActivityKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainActivityKt.MainScreen$lambda$5(mastgTestClass, displayString$delegate);
                }
            }, ComposableLambdaKt.rememberComposableLambda(2027959928, true, new Function2<Composer, Integer, Unit>() { // from class: org.owasp.mastestapp.MainActivityKt.MainScreen.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C51@1623L264:MainActivity.kt#vyvp3i");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        TextKt.m2715Text4IGK_g(MainActivityKt.MainScreen$lambda$1(displayString$delegate), TestTagKt.testTag(PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6664constructorimpl(16)), MainActivityKt.MASTG_TEXT_TAG), Color.INSTANCE.m4219getWhite0d7_KjU(), TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) FontFamily.INSTANCE.getMonospace(), 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3504, 0, 130992);
                    } else {
                        $composer3.skipToGroupEnd();
                    }
                }
            }, $composer2, 54), $composer2, 48, 0);
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: org.owasp.mastestapp.MainActivityKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.MainScreen$lambda$6($changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String MainScreen$lambda$1(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainScreen$lambda$5(final MastgTest mastgTestClass, final MutableState displayString$delegate) {
        Intrinsics.checkNotNullParameter(mastgTestClass, "$mastgTestClass");
        Intrinsics.checkNotNullParameter(displayString$delegate, "$displayString$delegate");
        new Thread(new Runnable() { // from class: org.owasp.mastestapp.MainActivityKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MainActivityKt.MainScreen$lambda$5$lambda$4(mastgTestClass, displayString$delegate);
            }
        }).start();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainScreen$lambda$5$lambda$4(MastgTest mastgTestClass, final MutableState displayString$delegate) {
        Intrinsics.checkNotNullParameter(mastgTestClass, "$mastgTestClass");
        Intrinsics.checkNotNullParameter(displayString$delegate, "$displayString$delegate");
        final String result = mastgTestClass.mastgTest();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: org.owasp.mastestapp.MainActivityKt$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MainActivityKt.MainScreen$lambda$5$lambda$4$lambda$3(result, displayString$delegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainScreen$lambda$5$lambda$4$lambda$3(String result, MutableState displayString$delegate) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(displayString$delegate, "$displayString$delegate");
        displayString$delegate.setValue(result);
    }
}
