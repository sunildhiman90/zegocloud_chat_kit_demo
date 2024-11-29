package com.example.zimkitdemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.zegocloud.zimkit.common.ZIMKitRouter
import com.zegocloud.zimkit.common.enums.ZIMKitConversationType
import com.zegocloud.zimkit.services.ZIMKit
import im.zego.zim.enums.ZIMErrorCode


class ConversationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }


    override fun onDestroy() {
        super.onDestroy()
        ZIMKit.disconnectUser()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        if (item.itemId == R.id.new_chat) {
            showNewChatDialog()
            return true
        }
        if (item.itemId == R.id.new_group) {
            showNewGroupDialog()
            return true
        }
        if (item.itemId == R.id.join_group) {
            showJoinGroupDialog()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showNewChatDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("New Chat")

        val editText = EditText(this)
        editText.hint = "User ID"
        builder.setView(editText)

        builder.setPositiveButton(
            "OK"
        ) { _, _ ->
            val userID = editText.text.toString()
            startChat(userID, ZIMKitConversationType.ZIMKitConversationTypePeer)
        }

        builder.setNegativeButton("Cancel", null)

        val dialog = builder.create()
        dialog.show()
    }

    private fun showNewGroupDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("New Group")

        val editText1 = EditText(this)
        val editText2 = EditText(this)
        val editText3 = EditText(this)

        editText1.hint = "Group Name"
        editText2.hint = "Group ID (Optional)"
        editText3.hint = "Invite User IDs (eg. 123;456)"

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.addView(editText1)
        layout.addView(editText2)
        layout.addView(editText3)
        builder.setView(layout)

        builder.setPositiveButton(
            "OK"
        ) { _, _ ->
            val groupName = editText1.text.toString()
            val groupId = editText2.text.toString()
            val userIDs =
                editText3.text.toString().split(";".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray()
            createGroup(
                groupName,
                groupId,
                ArrayList(listOf(*userIDs))
            )
        }
        builder.setNegativeButton("Cancel", null)

        val dialog = builder.create()
        dialog.show()
    }

    private fun showJoinGroupDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Join Group")

        val editText = EditText(this)
        editText.hint = "Group ID"
        builder.setView(editText)

        builder.setPositiveButton(
            "OK"
        ) { _, _ ->
            val groupID = editText.text.toString()
            joinGroup(groupID)
        }

        builder.setNegativeButton("Cancel", null)

        val dialog = builder.create()
        dialog.show()
    }

    private fun startChat(conversationID: String, type: ZIMKitConversationType) {
        //this will open the chat activity
        ZIMKitRouter.toMessageActivity(this, conversationID, type)
    }

    private fun createGroup(groupName: String, groupID: String, userIDs: List<String>) {
        ZIMKit.createGroup(
            groupName, groupID, userIDs
        ) { groupInfo, _, error ->
            if (error.code == ZIMErrorCode.SUCCESS) {
                startChat(groupInfo.id, ZIMKitConversationType.ZIMKitConversationTypeGroup)
            }
        }
    }

    private fun joinGroup(groupID: String) {
        ZIMKit.joinGroup(
            groupID
        ) { _, error ->
            if (error.code == ZIMErrorCode.SUCCESS || error.code == ZIMErrorCode.MEMBER_IS_ALREADY_IN_THE_GROUP) {
                startChat(groupID, ZIMKitConversationType.ZIMKitConversationTypeGroup)
            }
        }
    }
}