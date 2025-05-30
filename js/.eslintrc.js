module.exports = {
  parser: '@typescript-eslint/parser',
  plugins: ['@typescript-eslint', 'import'],
  extends: [
    'google',
    'plugin:@typescript-eslint/recommended',
    'plugin:import/errors',
    'plugin:import/warnings',
    'prettier',
  ],
  rules: {
    // import 순서 정렬
    'import/order': [
      'error',
      {
        groups: [
          ['builtin', 'external'],
          'internal',
          ['parent', 'sibling', 'index'],
        ],
        'newlines-between': 'always',
        alphabetize: {
          order: 'asc',
          caseInsensitive: true,
        },
      },
    ],
    // 함수 파라미터에 대한 타입 주석은 ts 레벨에서 파라미터의 타입을 명시하고 있으므로 jsdoc으로 중복 표현하지 않음
    // 함수 반환값에 대한 주석은 ts 레벨에서 함수의 반환 타입을 명시하고 있으므로 jsdoc으로 중복 표현하지 않음
    'valid-jsdoc': [
      'error',
      {
        requireReturn: false,
        requireParamType: false,
      },
    ],
    // //#region 주석에 공백이 자동으로 삽입되는 문제 해결
    'spaced-comment': [
      'error',
      'always',
      {
        line: {
          markers: ['#region', '#endregion'],
        },
      },
    ],
  },
  overrides: [
    {
      // api response object에서 snake case to camel case를 허용하기 위한 off
      files: [
        './src/maplestory/api/*/response/**',
        './src/maplestory/api/*/dto/**',
      ],
      rules: {
        camelcase: 'off',
      },
    },
    {
      files: ['./src/maplestory/api/*/dto/**'],
      rules: {
        'require-jsdoc': 'off',
      },
    },
  ],
  settings: {
    "import/parsers": {
      "@typescript-eslint/parser": ['.ts']
    },
    'import/resolver': {
      typescript: {}, // this loads <rootdir>/tsconfig.json to eslint
    },
  },
};
