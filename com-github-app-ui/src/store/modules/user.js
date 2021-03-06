import { login, logout, getInfo } from '@/api/login'
import { getToken, setToken, removeToken } from '@/utils/auth'

const user = {
  state: {
    token: getToken(),
    name: '',
    avatar: '',
    codes: [],
    roles: []
  },

  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_NAME: (state, name) => {
      state.name = name
    },
    SET_AVATAR: (state, avatar) => {
      state.avatar = avatar
    },
    SET_ROLES: (state, roles) => {
      state.roles = roles
    },
    SET_CODES: (state, codes) => {
      state.codes = codes
    }
  },

  actions: {
    // 登录
    Login({ commit }, userInfo) {
      userInfo.account = userInfo.account.trim()
      return new Promise((resolve, reject) => {
        login(userInfo).then(response => {
          const data = response
          setToken(data.data)
          commit('SET_TOKEN', data.data)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 获取用户信息
    GetInfo({ commit, state }) {
      return new Promise((resolve, reject) => {
        getInfo(state.token).then(response => {
          const data = response.data
          console.log(response.data)
          commit('SET_ROLES', data.account.role.name)
          commit('SET_NAME', data.account.name)
          commit('SET_AVATAR', process.env.BASE_API + '/open/avatar?imgName=' + data.account.photoUrl + '&height=80&width=80')
          commit('SET_CODES', data.list)
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 登出
    LogOut({ commit, state }) {
      return new Promise((resolve, reject) => {
        logout(state.token).then(() => {
          commit('SET_TOKEN', '')
          commit('SET_ROLES', [])
          commit('SET_CODES', [])
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 前端 登出
    FedLogOut({ commit }) {
      return new Promise(resolve => {
        commit('SET_TOKEN', '')
        commit('SET_ROLES', [])
        commit('SET_CODES', [])
        removeToken()
        resolve()
      })
    }
  }
}

export default user
