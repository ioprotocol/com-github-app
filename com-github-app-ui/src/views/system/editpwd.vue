<template>
  <div class="app-container">
    <p></p><p></p>
    <el-row>
      <el-col :span="12">
        <el-form :model="account" :rules="rules" ref="editForm" label-width="100px">
          <el-form-item label="旧密码" prop="oldPwd">
            <el-input type="password" v-model="account.oldPwd" auto-complete="off" clearable></el-input>
          </el-form-item>
          <el-form-item label="新密码" prop="newPwd">
            <el-input type="password" v-model="account.newPwd" auto-complete="off" clearable></el-input>
          </el-form-item>
          <el-form-item label="新密码确认" prop="newPwdCheck">
            <el-input type="password" v-model="account.newPwdCheck" auto-complete="off" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="cancelEdit">取 消</el-button>
            <el-button type="primary" @click="saveForm">确 定</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import { editAccountPwd } from '@/api/account'
  import { Message } from 'element-ui'

  export default {
    data() {
      var validateNewPwd = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'))
        } else {
          if (this.account.newPwdCheck !== '') {
            this.$refs.editForm.validateField('newPwdCheck')
          }
          callback()
        }
      }
      var validateNewPwdCheck = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'))
        } else if (value !== this.account.newPwd) {
          callback(new Error('两次输入密码不一致!'))
        } else {
          callback()
        }
      }
      return {
        account: {},
        rules: {
          oldPwd: [
            { required: true, message: '请输入旧密码', trigger: 'blur' },
            { pattern: /^[a-zA-Z0-9]+$/, message: '密码必须由数字字母组成', trigger: 'blur' },
            { min: 6, max: 50, message: '长度在 6 到 50 个字符', trigger: 'blur' }
          ],
          newPwd: [
            { required: true, message: '请输入新密码', trigger: 'blur' },
            { validator: validateNewPwd, trigger: 'blur' },
            { pattern: /^[a-zA-Z0-9]+$/, message: '密码必须由数字字母组成', trigger: 'blur' },
            { min: 6, max: 50, message: '长度在 6 到 50 个字符', trigger: 'blur' }
          ],
          newPwdCheck: [
            { required: true, message: '请再次输入新密码', trigger: 'blur' },
            { validator: validateNewPwdCheck, trigger: 'blur' },
            { pattern: /^[a-zA-Z0-9]+$/, message: '密码必须由数字字母组成', trigger: 'blur' },
            { min: 6, max: 50, message: '长度在 6 到 50 个字符', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      saveForm() {
        this.$refs['editForm'].validate((valid) => {
          if (valid) {
            editAccountPwd(this.account).then(rep => {
              Message({
                message: '密码修改成功',
                type: 'success',
                duration: 3 * 1000
              })
            })
          } else {
            return false
          }
        })
      },
      cancelEdit() {
        this.$refs['editForm'].resetFields()
      }
    }
  }
</script>
