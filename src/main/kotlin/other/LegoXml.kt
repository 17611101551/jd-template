package other

fun LegoXml(
        packageName: String,
        activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:paddingLeft="16dp"
    android:paddingBottom="16dp"
    android:paddingTop="16dp">

    <ImageView
        android:id="@+id/iv_template_icon"
        android:layout_width="111dp"
        android:layout_height="80dp"
        android:scaleType="centerCrop"
        app:layout_constraintRight_toRightOf="parent"
        android:layout_marginRight="16dp"
        android:visibility="visible"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>

    <TextView
        android:id="@+id/tv_template_title"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:textSize="16dp"
        android:textColor="#333333"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toLeftOf="@id/iv_template_icon"
        android:layout_marginRight="16dp"
        android:maxLines="2"
        android:ellipsize="end"
        tools:text="美国疫情和贸易战无法对车子在投资这必看"/>

    <View
        android:id="@+id/template_line"
        android:layout_width="match_parent"
        android:layout_height="0.5dp"
        app:layout_constraintBottom_toBottomOf="parent"
        android:layout_marginRight="16dp"
        android:background="#eeeeee"/>

</androidx.constraintlayout.widget.ConstraintLayout>
"""